package com.flowers.services.Impl;

import com.flowers.models.Fournisseur;
import com.flowers.reposiory.FournisseurRepository;
import com.flowers.services.FournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> findAllFournisseurs() {
        return null;
    }

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return null;
    }

    @Override
    public Optional<Fournisseur> findFournisseurById(Long fourId) {
        return Optional.empty();
    }

    @Override
    public Fournisseur updateFournisseur(Long fourId, Fournisseur fournisseur) {
        return null;
    }

    @Override
    public void deleteFournisseur(Long fourId) {

    }

    @Override
    public Fournisseur findByCode(String code) {
        return null;
    }

    @Override
    public Fournisseur findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<Fournisseur> ListFournisseurByCode(String code) {
        return null;
    }

    @Override
    public List<Fournisseur> ListFournisseurByDesignation(String designation) {
        return null;
    }
}
