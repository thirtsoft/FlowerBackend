package com.flowers.controllers;

import com.flowers.controllers.api.FournisseurApi;
import com.flowers.models.Fournisseur;
import com.flowers.services.FournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FournisseurController implements FournisseurApi {

    private final FournisseurService fournisseurService;

    @Override
    public ResponseEntity<Fournisseur> save(Fournisseur fournisseur) {
        return null;
    }

    @Override
    public ResponseEntity<Fournisseur> update(Long id, Fournisseur fournisseur) {
        return null;
    }

    @Override
    public ResponseEntity<Fournisseur> findById(Long id) {
        return null;
    }

    @Override
    public List<Fournisseur> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
