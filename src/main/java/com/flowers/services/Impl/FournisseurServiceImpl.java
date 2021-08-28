package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
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

        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        if (fournisseur.getReference() != null) {
            throw new ResourceNotFoundException("Fournisseur already exists");
        }
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Optional<Fournisseur> findFournisseurById(Long fourId) {
        if (!fournisseurRepository.existsById(fourId)) {
            throw new ResourceNotFoundException("Fournisseur that id is " + fourId + "not found");
        }
        return fournisseurRepository.findById(fourId);
    }

    @Override
    public Fournisseur updateFournisseur(Long fourId, Fournisseur fournisseur) {
        fournisseur.setId(fourId);
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void deleteFournisseur(Long fourId) {
        if (!fournisseurRepository.existsById(fourId)) {
            throw new ResourceNotFoundException("Fournisseur not found");
        }
        fournisseurRepository.deleteById(fourId);
    }


}
