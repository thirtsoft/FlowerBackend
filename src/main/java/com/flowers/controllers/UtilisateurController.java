package com.flowers.controllers;

import com.flowers.controllers.api.UtilisateurApi;
import com.flowers.dtos.UtilisateurDto;
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
    public ResponseEntity<UtilisateurDto> saveUtilisateur(UtilisateurDto utilisateurDto) {
        return null;
    }

    @Override
    public ResponseEntity<UtilisateurDto> updateUtilisateur(Long userId, UtilisateurDto utilisateurDto) {
        return null;
    }

    @Override
    public ResponseEntity<UtilisateurDto> getUtilisateurById(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs() {
        return null;
    }

    @Override
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateursOrderByIdDesc() {
        return null;
    }

    @Override
    public void deleteUtilisateur(Long userId) {
        utilisateurService.deleteUtilisateur(userId);
    }
}
