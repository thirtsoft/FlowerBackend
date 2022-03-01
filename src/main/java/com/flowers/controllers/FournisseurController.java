package com.flowers.controllers;

import com.flowers.controllers.api.FournisseurApi;
import com.flowers.dtos.FournisseurDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Fournisseur;
import com.flowers.services.FournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class FournisseurController implements FournisseurApi {

    private final FournisseurService fournisseurService;


    @Override
    public ResponseEntity<FournisseurDto> saveFournisseur(FournisseurDto fournisseurDto) {
        return null;
    }

    @Override
    public ResponseEntity<FournisseurDto> updateFournisseur(Long id, FournisseurDto fournisseurDto) {
        return null;
    }

    @Override
    public ResponseEntity<FournisseurDto> getFournisseurById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<FournisseurDto>> getAllFournisseurs() {
        return null;
    }

    @Override
    public ResponseEntity<List<FournisseurDto>> getAllFournisseursOrderByIdDesc() {
        return null;
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
