package com.flowers.services.Impl;

import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.ZoneLivraisonDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Fournisseur;
import com.flowers.models.ZoneLivraison;
import com.flowers.reposiory.ZoneLivraisonRepository;
import com.flowers.services.ZoneLivraisonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ZoneLivraisonServiceImpl implements ZoneLivraisonService {

    private final ZoneLivraisonRepository zoneLivraisonRepository;

    public ZoneLivraisonServiceImpl(ZoneLivraisonRepository zoneLivraisonRepository) {
        this.zoneLivraisonRepository = zoneLivraisonRepository;
    }

    @Override
    public ZoneLivraisonDto saveZoneLivraison(ZoneLivraisonDto zoneLivraisonDto) {
        zoneLivraisonDto.setActif(true);
        return ZoneLivraisonDto.fromEntityToDto(
                zoneLivraisonRepository.save(
                        ZoneLivraisonDto.fromDtoToEntity(zoneLivraisonDto))
        );
    }

    @Override
    public ZoneLivraisonDto updateZoneLivraison(Long zoneId, ZoneLivraisonDto zoneLivraisonDto) {
        if (!zoneLivraisonRepository.existsById(zoneId)) {
            throw new ResourceNotFoundException("Zone not found");
        }
        Optional<ZoneLivraison> optionalZoneLivraison = zoneLivraisonRepository.findById(zoneId);
        if (!optionalZoneLivraison.isPresent()) {
            throw new ResourceNotFoundException("Zone not found");
        }
        ZoneLivraisonDto zoneLivraisonDtoResult = ZoneLivraisonDto.fromEntityToDto(optionalZoneLivraison.get());
        zoneLivraisonDtoResult.setId(zoneLivraisonDto.getId());
        zoneLivraisonDtoResult.setLibelle(zoneLivraisonDto.getLibelle());
        return ZoneLivraisonDto.fromEntityToDto(
                zoneLivraisonRepository.save(
                        ZoneLivraisonDto.fromDtoToEntity(zoneLivraisonDtoResult)
                )
        );
    }

    @Override
    public ZoneLivraisonDto findZoneLivraisonById(Long zoneId) {
        if (zoneId == null) {
            log.error("Zone not found");
            return null;
        }
        Optional<ZoneLivraison> optionalZoneLivraison = zoneLivraisonRepository.findById(zoneId);
        return Optional.of(ZoneLivraisonDto.fromEntityToDto(optionalZoneLivraison.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnune zone avec l'Id = " + zoneId + "n'a été trouvé")
        );
    }

    @Override
    public List<ZoneLivraisonDto> findAllZoneLivraisons() {
        return zoneLivraisonRepository.findAll().stream()
                .map(ZoneLivraisonDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteZoneLivraison(Long zoneId) {
        if (zoneId == null) {
            log.error("Zone null");
            return;
        }
        ZoneLivraison zoneLivraison = zoneLivraisonRepository.findById(zoneId).get();
        zoneLivraison.setActif(false);
        zoneLivraisonRepository.save(zoneLivraison);
    }
}
