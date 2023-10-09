package com.flowers.services;

import com.flowers.dtos.ZoneLivraisonDto;
import com.flowers.models.ZoneLivraison;

import java.util.List;

public interface ZoneLivraisonService {

    ZoneLivraisonDto findZoneLivraisonById(Long zoneId);

    ZoneLivraisonDto saveZoneLivraison(ZoneLivraisonDto zoneLivraisonDto);

    ZoneLivraisonDto updateZoneLivraison(Long zoneId, ZoneLivraisonDto zoneLivraisonDto);

    List<ZoneLivraisonDto> findAllZoneLivraisons();

    void deleteZoneLivraison(Long zoneId);
}
