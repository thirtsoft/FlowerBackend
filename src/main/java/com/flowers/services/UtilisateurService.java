package com.flowers.services;

import com.flowers.models.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {

    List<Utilisateur> findAllUtilisateurs();

    Utilisateur saveUtilisateur(Utilisateur utilisateur);

    Optional<Utilisateur> findUtilisateurById(Long userId);

    Utilisateur updateUtilisateur(Long catId, Utilisateur utilisateur);

    void deleteUtilisateur(Long userId);

    Utilisateur findByCode(String code);

    Utilisateur findByDesignation(String designation);

    List<Utilisateur> ListUtilisateurByCode(String designation);

    List<Utilisateur> ListUtilisateurByDesignation(String designation);


}
