package com.flowers.controllers;

import com.flowers.controllers.api.ZoneLivraisonApi;
import com.flowers.dtos.ZoneLivraisonDto;
import com.flowers.services.ZoneLivraisonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZoneLivraisonController implements ZoneLivraisonApi {

    private final ZoneLivraisonService zoneLivraisonService;

    public ZoneLivraisonController(ZoneLivraisonService zoneLivraisonService) {
        this.zoneLivraisonService = zoneLivraisonService;
    }

    @Override
    public ResponseEntity<ZoneLivraisonDto> createZoneLivraison(ZoneLivraisonDto zoneLivraisonDto) {
        ZoneLivraisonDto zoneLivraisonDtoResult = zoneLivraisonService.saveZoneLivraison(zoneLivraisonDto);
        return new ResponseEntity<>(zoneLivraisonDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ZoneLivraisonDto> updateZoneLivraison(Long zoneId, ZoneLivraisonDto zoneLivraisonDto) {
        ZoneLivraisonDto zoneLivraisonDtoResult = zoneLivraisonService.updateZoneLivraison(zoneId, zoneLivraisonDto);
        return new ResponseEntity<>(zoneLivraisonDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ZoneLivraisonDto> getZoneLivraisonById(Long zoneId) {
        ZoneLivraisonDto zoneLivraisonDto = zoneLivraisonService.findZoneLivraisonById(zoneId);
        return new ResponseEntity<>(zoneLivraisonDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ZoneLivraisonDto>> getAllActiveZoneLivraisons() {
        List<ZoneLivraisonDto> zoneLivraisonDtoList = zoneLivraisonService.findAllZoneLivraisons();
        return new ResponseEntity<>(zoneLivraisonDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteZoneLivraison(Long zoneId) {
        zoneLivraisonService.deleteZoneLivraison(zoneId);
    }
}
