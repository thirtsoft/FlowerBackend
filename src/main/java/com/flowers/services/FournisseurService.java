package com.flowers.services;

import com.flowers.models.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurService {

    List<Fournisseur> findAllFournisseurs();

    Fournisseur saveFournisseur(Fournisseur fournisseur);

    Optional<Fournisseur> findFournisseurById(Long fourId);

    Fournisseur updateFournisseur(Long fourId, Fournisseur fournisseur);

    void deleteFournisseur(Long fourId);

    Fournisseur findByCode(String code);

    Fournisseur findByDesignation(String designation);

    List<Fournisseur> ListFournisseurByCode(String code);

    List<Fournisseur> ListFournisseurByDesignation(String designation);


}
