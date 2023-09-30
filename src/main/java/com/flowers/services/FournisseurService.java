package com.flowers.services;

import com.flowers.dtos.FournisseurDto;

import java.math.BigDecimal;
import java.util.List;

public interface FournisseurService {

    FournisseurDto saveFournisseur(FournisseurDto fournisseurDto);

    FournisseurDto findFournisseurById(Long fourId);

    FournisseurDto updateFournisseur(Long fourId, FournisseurDto fournisseurDto);

    BigDecimal countNumberOfFournisseur();

    List<FournisseurDto> findAllActiveFournisseurs();

    void deleteFournisseur(Long fourId);


}
