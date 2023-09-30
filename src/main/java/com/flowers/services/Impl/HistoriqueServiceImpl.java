package com.flowers.services.Impl;

import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.models.HistoriqueCommande;
import com.flowers.models.HistoriqueLogin;
import com.flowers.reposiory.HistoriqueCommandeRepository;
import com.flowers.reposiory.HistoriqueLoginRepository;
import com.flowers.services.HistoriqueService;
import com.flowers.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class HistoriqueServiceImpl implements HistoriqueService {

    private final HistoriqueCommandeRepository historiqueCommandeRepository;

    private final HistoriqueLoginRepository historiqueLoginRepository;

    public HistoriqueServiceImpl(HistoriqueCommandeRepository historiqueCommandeRepository, HistoriqueLoginRepository historiqueLoginRepository) {
        this.historiqueCommandeRepository = historiqueCommandeRepository;
        this.historiqueLoginRepository = historiqueLoginRepository;
    }

    @Override
    public BigDecimal countNumberOfHistoriqueCommandes() {
        return historiqueCommandeRepository.countNumberOfHistoriqueCommandes();
    }

    @Override
    public List<HistoriqueCommandeDto> findAllActiveHistoriqueCommandes() {
        return historiqueCommandeRepository.findAll().stream()
                .map(HistoriqueCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteHistoriqueCommande(Long id) {
        if (id == null) {
            log.error("HistoriqueCommande Id is null");
            return;
        }
        HistoriqueCommande historiqueCommande = historiqueCommandeRepository.findById(id).get();
        historiqueCommande.setActif(false);
        historiqueCommandeRepository.save(historiqueCommande);
    }

    @Override
    public HistoriqueLoginDto saveHistoriqueLogin(HistoriqueLoginDto historiqueLoginDto) {
        historiqueLoginDto.setActif(true);
        return HistoriqueLoginDto.fromEntityToDto(
                historiqueLoginRepository.save(
                        HistoriqueLoginDto.fromDtoToEntity(historiqueLoginDto)
                )
        );
    }


    @Override
    public BigDecimal countNumberOfHistoriqueLogins() {
        return historiqueLoginRepository.countNumberOfHistoriqueLogins();
    }

    @Override
    public List<HistoriqueLoginDto> findAllActiveHistoriqueLogins() {
        return historiqueLoginRepository.findAll().stream()
                .map(HistoriqueLoginDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteHistoriqueLogin(Long id) {
        if (id == null) {
            log.error("Fournisseur Id is null");
            return;
        }
        HistoriqueLogin historiqueLogin = historiqueLoginRepository.findById(id).get();
        historiqueLogin.setActif(false);
        historiqueLoginRepository.save(historiqueLogin);
    }
}