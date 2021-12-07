package com.flowers.services.Impl;

import com.flowers.models.Utilisateur;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    
    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        return null;
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public Optional<Utilisateur> findUtilisateurById(Long userId) {
        return Optional.empty();
    }

    @Override
    public Utilisateur updateUtilisateur(Long catId, Utilisateur utilisateur) {
        return null;
    }

    @Override
    public void deleteUtilisateur(Long userId) {

    }

    @Override
    public Utilisateur findByCode(String code) {
        return null;
    }

    @Override
    public Utilisateur findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<Utilisateur> ListUtilisateurByCode(String designation) {
        return null;
    }

    @Override
    public List<Utilisateur> ListUtilisateurByDesignation(String designation) {
        return null;
    }

    @Override
    public Utilisateur findById(Long id) {
        return null;
    }
}
