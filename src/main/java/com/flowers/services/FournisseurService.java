package com.flowers.services;

import com.flowers.dtos.EmailDto;
import com.flowers.dtos.FournisseurDto;
import com.flowers.models.Fournisseur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FournisseurService {

    List<FournisseurDto> findAllFournisseurs();

    FournisseurDto saveFournisseur(FournisseurDto fournisseurDto);

    FournisseurDto findFournisseurById(Long fourId);

    FournisseurDto updateFournisseur(Long fourId, FournisseurDto fournisseurDto);

    BigDecimal countNumberOfFournisseur();

    List<FournisseurDto> findFournisseurByOrderByIdDesc();

    void delete(Long fourId);

    List<FournisseurDto> findAllActiveFournisseurs();

    void deleteFournisseur(Long fourId);


}
