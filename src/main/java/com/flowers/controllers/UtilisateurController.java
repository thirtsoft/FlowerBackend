package com.flowers.controllers;

import com.flowers.controllers.api.UtilisateurApi;
import com.flowers.models.Utilisateur;
import com.flowers.services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilisateurController implements UtilisateurApi {

    private final UtilisateurService utilisateurService;

    @Override
    public ResponseEntity<Utilisateur> save(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public ResponseEntity<Utilisateur> update(Long id, Utilisateur utilisateur) {
        return null;
    }

    @Override
    public ResponseEntity<Utilisateur> findById(Long id) {
        return null;
    }

    @Override
    public List<Utilisateur> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
