package com.flowers.services.Impl;

import com.flowers.dtos.FournisseurDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Fournisseur;
import com.flowers.reposiory.FournisseurRepository;
import com.flowers.services.FournisseurService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private final FournisseurRepository fournisseurRepository;

    @Override
    public FournisseurDto saveFournisseur(FournisseurDto fournisseurDto) {
        fournisseurDto.setActif(true);
        return FournisseurDto.fromEntityToDto(
                fournisseurRepository.save(
                        FournisseurDto.fromDtoToEntity(fournisseurDto)
                )
        );
    }

    @Override
    public FournisseurDto updateFournisseur(Long fourId, FournisseurDto fournisseurDto) {
        if (!fournisseurRepository.existsById(fourId)) {
            throw new ResourceNotFoundException("Fournisseur not found");
        }
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(fourId);
        if (!optionalFournisseur.isPresent()) {
            throw new ResourceNotFoundException("Fournisseur not found");
        }
        FournisseurDto fournisseurDtoResult = FournisseurDto.fromEntityToDto(optionalFournisseur.get());
        fournisseurDtoResult.setReference(fournisseurDto.getReference());
        fournisseurDtoResult.setFirstName(fournisseurDto.getFirstName());
        fournisseurDtoResult.setLastName(fournisseurDto.getLastName());
        fournisseurDtoResult.setTelephone(fournisseurDtoResult.getTelephone());
        fournisseurDtoResult.setEmail(fournisseurDto.getEmail());
        fournisseurDtoResult.setStateDto(fournisseurDto.getStateDto());
        return FournisseurDto.fromEntityToDto(
                fournisseurRepository.save(
                        FournisseurDto.fromDtoToEntity(fournisseurDtoResult)
                )
        );
    }

    @Override
    public FournisseurDto findFournisseurById(Long fourId) {
        if (fourId == null) {
            log.error("Fournisseur Id is null");
            return null;
        }
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(fourId);
        return Optional.of(FournisseurDto.fromEntityToDto(optionalFournisseur.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Fournisseur avec l'Id = " + fourId + "n'a été trouvé")
        );
    }

    @Override
    public List<FournisseurDto> findAllActiveFournisseurs() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal countNumberOfFournisseur() {
        return fournisseurRepository.countNumberOfFournisseur();
    }


    @Override
    public void deleteFournisseur(Long fourId) {
        if (fourId == null) {
            log.error("Fournisseur not found");
            return;
        }
        Fournisseur fournisseur = fournisseurRepository.findById(fourId).get();
        fournisseur.setActif(false);
        fournisseurRepository.save(fournisseur);
    }
}
