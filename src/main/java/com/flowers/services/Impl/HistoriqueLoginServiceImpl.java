package com.flowers.services.Impl;

import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.dtos.UtilisateurDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.HistoriqueLogin;
import com.flowers.reposiory.HistoriqueLoginRepository;
import com.flowers.services.HistoriqueLoginService;
import com.flowers.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class HistoriqueLoginServiceImpl implements HistoriqueLoginService {

    private final HistoriqueLoginRepository historiqueLoginRepository;

    private final UtilisateurService utilisateurService;

    @Autowired
    public HistoriqueLoginServiceImpl(HistoriqueLoginRepository historiqueLoginRepository,
                                      UtilisateurService utilisateurService) {
        this.historiqueLoginRepository = historiqueLoginRepository;
        this.utilisateurService = utilisateurService;
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
    public HistoriqueLoginDto saveHistoriqueLoginWithConnectedUser(HistoriqueLoginDto historiqueLoginDto, Long userId) {

        UtilisateurDto utilisateurDto = utilisateurService.findUtilisateurById(userId);

        historiqueLoginDto.setUtilisateurDto(utilisateurDto);
        historiqueLoginDto.setCreatedDate(new Date());

        return HistoriqueLoginDto.fromEntityToDto(
                historiqueLoginRepository.save(
                        HistoriqueLoginDto.fromDtoToEntity(historiqueLoginDto)
                )
        );
    }

    @Override
    public HistoriqueLoginDto findHistoriqueLoginById(Long id) {
        if (id == null) {
            log.error("HistoriqueLogin Id is null");
            return null;
        }

        Optional<HistoriqueLogin> historiqueLogin = historiqueLoginRepository.findById(id);

        return Optional.of(HistoriqueLoginDto.fromEntityToDto(historiqueLogin.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Fournisseur avec l'Id = " + id + "n'a été trouvé")
        );
    }

    @Override
    public List<HistoriqueLoginDto> findAllHistoriqueLogins() {
        return historiqueLoginRepository.findAll().stream()
                .map(HistoriqueLoginDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoriqueLoginDto> findAllHistoriqueLoginsOrderDesc() {
        return historiqueLoginRepository.findByOrderByIdDesc().stream()
                .map(HistoriqueLoginDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal countNumberOfHistoriqueLogins() {
        return historiqueLoginRepository.countNumberOfHistoriqueLogins();
    }

    @Override
    public void deleteHistorique(Long id) {
        if (id == null) {
            log.error("Fournisseur Id is null");
            return;
        }
        historiqueLoginRepository.deleteById(id);
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
