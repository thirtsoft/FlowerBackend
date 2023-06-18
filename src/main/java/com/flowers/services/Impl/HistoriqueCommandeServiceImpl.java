package com.flowers.services.Impl;

import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.HistoriqueCommande;
import com.flowers.reposiory.HistoriqueCommandeRepository;
import com.flowers.services.HistoriqueCommandeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class HistoriqueCommandeServiceImpl implements HistoriqueCommandeService {

    private final HistoriqueCommandeRepository historiqueCommandeRepository;


    @Autowired
    public HistoriqueCommandeServiceImpl(HistoriqueCommandeRepository historiqueCommandeRepository) {
        this.historiqueCommandeRepository = historiqueCommandeRepository;
    }

    @Override
    public HistoriqueCommandeDto saveHistoriqueCommande(HistoriqueCommandeDto historiqueCommandeDto) {
        historiqueCommandeDto.setActif(true);
        return HistoriqueCommandeDto.fromEntityToDto(
                historiqueCommandeRepository.save(
                        HistoriqueCommandeDto.fromDtoToEntity(historiqueCommandeDto)
                )
        );
    }

    @Override
    public HistoriqueCommandeDto saveHistoriqueCommandeWithConnectedUser(HistoriqueCommandeDto historiqueCommandeDto, Long userId) {
        return null;
    }

    @Override
    public HistoriqueCommandeDto findHistoriqueCommandeById(Long id) {
        if (id == null) {
            log.error("HistoriqueCommande Id is null");
            return null;
        }
        Optional<HistoriqueCommande> optionalHistoriqueCommande = historiqueCommandeRepository.findById(id);

        return Optional.of(HistoriqueCommandeDto.fromEntityToDto(optionalHistoriqueCommande.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun HistoriqueCommande avec l'Id = " + id + "n'a été trouvé")
        );
    }

    @Override
    public List<HistoriqueCommandeDto> findAllHistoriqueCommandes() {
        return historiqueCommandeRepository.findAll().stream()
                .map(HistoriqueCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoriqueCommandeDto> findAllHistoriqueCommandeOrderDesc() {
        return historiqueCommandeRepository.findByOrderByIdDesc().stream()
                .map(HistoriqueCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal countNumberOfHistoriqueCommandes() {
        return historiqueCommandeRepository.countNumberOfHistoriqueCommandes();
    }

    @Override
    public void deleteHistorique(Long id) {
        if (id == null) {
            log.error("HistoriqueCommande Id is null");
            return;
        }
        historiqueCommandeRepository.deleteById(id);
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

}
