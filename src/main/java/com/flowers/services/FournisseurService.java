package com.flowers.services;

import com.flowers.models.Fournisseur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FournisseurService {

    List<Fournisseur> findAllFournisseurs();

    Fournisseur saveFournisseur(Fournisseur fournisseur);

    Optional<Fournisseur> findFournisseurById(Long fourId);

    Fournisseur updateFournisseur(Long fourId, Fournisseur fournisseur);

    BigDecimal countNumberOfFournisseur();

    List<Fournisseur> findFournisseurByOrderByIdDesc();

    void deleteFournisseur(Long fourId);


}
