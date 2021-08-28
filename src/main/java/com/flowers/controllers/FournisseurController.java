package com.flowers.controllers;

import com.flowers.controllers.api.FournisseurApi;
import com.flowers.exceptions.ResourceNotFoundException;
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
        return ResponseEntity.ok(fournisseurService.saveFournisseur(fournisseur));
    }

    @Override
    public ResponseEntity<Fournisseur> update(Long id, Fournisseur fournisseur) {
        fournisseur.setId(id);
        return ResponseEntity.ok(fournisseurService.saveFournisseur(fournisseur));
    }

    @Override
    public ResponseEntity<Fournisseur> getFournisseurById(Long id) throws ResourceNotFoundException {
        Fournisseur fournisseur = fournisseurService.findFournisseurById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found"));
        return ResponseEntity.ok().body(fournisseur);
    }

    @Override
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        return ResponseEntity.ok(fournisseurService.findAllFournisseurs());
    }

    @Override
    public void delete(Long id) {
        fournisseurService.deleteFournisseur(id);
    }
}
