package com.flowers.controllers;

import com.flowers.controllers.api.UtilisateurApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Utilisateur;
import com.flowers.services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilisateurController implements UtilisateurApi {

    private final UtilisateurService utilisateurService;


    @Override
    public ResponseEntity<Utilisateur> saveUtilisateur(Utilisateur utilisateur) {
        return ResponseEntity.ok(utilisateurService.saveUtilisateur(utilisateur));
    }

    @Override
    public ResponseEntity<Utilisateur> updateUtilisateur(Long userId, Utilisateur utilisateur) {
        utilisateur.setId(userId);
        return ResponseEntity.ok(utilisateurService.saveUtilisateur(utilisateur));
    }

    @Override
    public ResponseEntity<Utilisateur> getUtilisateurById(Long userId) throws ResourceNotFoundException {
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found"));
        return ResponseEntity.ok().body(utilisateur);
    }

    @Override
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurList = utilisateurService.findAllUtilisateurs();
        return new ResponseEntity<>(utilisateurList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Utilisateur>> getAllUtilisateursOrderByIdDesc() {
        List<Utilisateur> utilisateurList = utilisateurService.findUtilisateurByOrderByIdDesc();
        return new ResponseEntity<>(utilisateurList, HttpStatus.OK);
    }

    @Override
    public void deleteUtilisateur(Long userId) {
        utilisateurService.deleteUtilisateur(userId);
    }
}
