package com.flowers.services;

import com.flowers.models.Subcategory;
import com.flowers.models.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {

    List<Utilisateur> findAllUtilisateurs();

    Utilisateur saveUtilisateur(Utilisateur utilisateur);

    Optional<Utilisateur> findUtilisateurById(Long userId);

    Utilisateur updateUtilisateur(Long userId, Utilisateur utilisateur);


    List<Utilisateur> findUtilisateurByOrderByIdDesc();

    void deleteUtilisateur(Long userId);
}
