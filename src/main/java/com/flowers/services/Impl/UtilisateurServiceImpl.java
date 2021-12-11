package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
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
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Optional<Utilisateur> findUtilisateurById(Long userId) {
        if (!utilisateurRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Utilisateur that id is " + userId + "not found");
        }
        return utilisateurRepository.findById(userId);

    }

    @Override
    public Utilisateur updateUtilisateur(Long userId, Utilisateur utilisateur) {
        if (!utilisateurRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Utilisateur that id is" + userId + "is not found");
        }
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(userId);

        if (!optionalUtilisateur.isPresent()) {
            throw new ResourceNotFoundException("Utilisateur not found");
        }

        Utilisateur utilisateurResult = optionalUtilisateur.get();
        utilisateurResult.setName(utilisateur.getName());
        utilisateurResult.setUsername(utilisateur.getUsername());
        utilisateurResult.setEmail(utilisateur.getEmail());
        utilisateurResult.setActive(utilisateur.isActive());
        utilisateurResult.setPassword(utilisateur.getPassword());

        return utilisateurRepository.save(utilisateurResult);
    }

    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public List<Utilisateur> findUtilisateurByOrderByIdDesc() {
        return utilisateurRepository.findByOrderByIdDesc();
    }

    @Override
    public void deleteUtilisateur(Long userId) {
        if (!utilisateurRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Utilisateur that id is" + userId + "is not found");
        }
        utilisateurRepository.deleteById(userId);
    }

}
