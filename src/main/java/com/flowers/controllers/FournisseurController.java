package com.flowers.controllers;

import com.flowers.controllers.api.FournisseurApi;
import com.flowers.dtos.FournisseurDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Fournisseur;
import com.flowers.services.FournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "https://portail.fleurpourtous.com")
//@CrossOrigin
@RestController
@AllArgsConstructor
public class FournisseurController implements FournisseurApi {

    private final FournisseurService fournisseurService;


    @Override
    public ResponseEntity<FournisseurDto> saveFournisseur(FournisseurDto fournisseurDto) {
        FournisseurDto fournisseurDtoResult = fournisseurService.saveFournisseur(fournisseurDto);
        return new ResponseEntity<>(fournisseurDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FournisseurDto> updateFournisseur(Long id, FournisseurDto fournisseurDto) {
        fournisseurDto.setId(id);
        FournisseurDto fournisseurDtoResult = fournisseurService.saveFournisseur(fournisseurDto);
        return new ResponseEntity<>(fournisseurDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FournisseurDto> getFournisseurById(Long id) {
        FournisseurDto fournisseurDtoResult = fournisseurService.findFournisseurById(id);
        return new ResponseEntity<>(fournisseurDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FournisseurDto>> getAllFournisseurs() {
        List<FournisseurDto> fournisseurDtoList = fournisseurService.findAllFournisseurs();
        return new ResponseEntity<>(fournisseurDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FournisseurDto>> getAllFournisseursOrderByIdDesc() {
        List<FournisseurDto> fournisseurDtoList = fournisseurService.findFournisseurByOrderByIdDesc();
        return new ResponseEntity<>(fournisseurDtoList, HttpStatus.OK);
    }

    @Override
    public BigDecimal countNumberOfFournisseur() {
        return fournisseurService.countNumberOfFournisseur();
    }

    @Override
    public void delete(Long id) {
        fournisseurService.deleteFournisseur(id);
    }
}
