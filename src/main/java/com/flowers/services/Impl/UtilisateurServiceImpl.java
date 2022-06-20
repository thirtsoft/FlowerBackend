package com.flowers.services.Impl;

import com.flowers.dtos.UtilisateurDto;
import com.flowers.enums.RoleName;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Role;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.RoleRepository;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    private final RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto) {
        return UtilisateurDto.fromEntityToDto(
                utilisateurRepository.save(
                        UtilisateurDto.fromDtoToEntity(utilisateurDto)
                )
        );
    }

    @Override
    public void addRoleToUser(String username, RoleName roleName) {
        Role role = roleRepository.findByName(roleName).get();

        Utilisateur utilisateur = utilisateurRepository.findByUsername(username).get();

        utilisateur.getRoles().add(role);
    }

    @Override
    public UtilisateurDto findUtilisateurById(Long userId) {
        if (userId == null) {
            log.error("Utilisateur Id is null");
            return null;
        }

        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(userId);

        return Optional.of(UtilisateurDto.fromEntityToDto(utilisateur.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Utilisateur avec l'Id = " + userId + "n'a été trouvé")
        );
    }

    @Override
    public UtilisateurDto findByUsername(String username) {
        if (username == null) {
            log.error("Utilisateur with this username is null");
            return null;
        }

        Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(username);

        return Optional.of(UtilisateurDto.fromEntityToDto(utilisateur.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Utilisateur avec l'Id = " + username + "n'a été trouvé")
        );
    }

    @Override
    public UtilisateurDto updateUtilisateur(Long userId, UtilisateurDto utilisateurDto) {
        if (!utilisateurRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Utilisateur not found");
        }

        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(userId);

        if (!optionalUtilisateur.isPresent()) {
            throw new ResourceNotFoundException("Utilisateur not found");
        }

        UtilisateurDto utilisateurDtoResult = UtilisateurDto.fromEntityToDto(optionalUtilisateur.get());

        utilisateurDtoResult.setName(utilisateurDto.getName());
        utilisateurDtoResult.setUsername(utilisateurDto.getUsername());
        utilisateurDtoResult.setEmail(utilisateurDto.getEmail());
        utilisateurDtoResult.setMobile(utilisateurDto.getMobile());
        utilisateurDtoResult.setPassword(bCryptPasswordEncoder.encode(utilisateurDto.getPassword()));

        return UtilisateurDto.fromEntityToDto(
                utilisateurRepository.save(
                        UtilisateurDto.fromDtoToEntity(utilisateurDtoResult)
                )
        );
    }

    @Override
    public List<UtilisateurDto> findAllUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UtilisateurDto> findUtilisateurByOrderByIdDesc() {
        return utilisateurRepository.findByOrderByIdDesc().stream()
                .map(UtilisateurDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateUsernameOfUtilisateurByUsername(String username, String newUsername) {
        Optional<Utilisateur> existsUser = utilisateurRepository.findByUsername(username);
        Utilisateur user;
        if (existsUser.isPresent()) {
            user = existsUser.get();
            user.setUsername(newUsername);
            this.utilisateurRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    public boolean updateUsernameOfUtilisateurByUserId(String id, String newUsername) {
        Optional<Utilisateur> existsUser = utilisateurRepository.findById(Long.valueOf(id));
        Utilisateur user;
        if (existsUser.isPresent()) {
            user = existsUser.get();
            user.setUsername(newUsername);
            this.utilisateurRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    public boolean updateCustomerPasswordByUsername(String username, String oldPass, String newPass) {
        Optional<Utilisateur> existsUser = this.utilisateurRepository.findByUsername(username);
        Utilisateur user;
        if (existsUser.isPresent()) {
            user = existsUser.get();

            if (passwordEncoder.matches(oldPass, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newPass));
                this.utilisateurRepository.save(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateCustomerPasswordByUserId(String id, String oldPass, String newPass) {
        Optional<Utilisateur> existsUser = utilisateurRepository.findById(Long.valueOf(id));
        Utilisateur user;
        if (existsUser.isPresent()) {
            user = existsUser.get();

            if (passwordEncoder.matches(oldPass, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newPass));
                this.utilisateurRepository.save(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateCustomerProfileByUsername(String username, String name, String newUsername, String email, String mobile) {
        Optional<Utilisateur> existsUser = this.utilisateurRepository.findByUsername(username);
        Utilisateur user;
        if (existsUser.isPresent()) {
            user = existsUser.get();
            user.setName(name);
            user.setUsername(newUsername);
            user.setEmail(email);
            user.setMobile(mobile);

            utilisateurRepository.save(user);

            return true;

        }
        return false;
    }

    @Override
    public UtilisateurDto activatedUser(String isActive, String id) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(Long.valueOf(id));
        Utilisateur utilisateur = optionalUtilisateur.get();
        utilisateur.setActive(Boolean.valueOf(isActive));

        return UtilisateurDto.fromEntityToDto(utilisateurRepository.save(utilisateur));
    }

    @Override
    public BigDecimal countNumberOfRegisterInMonth() {
        return utilisateurRepository.countNumberOfRegisterInMonth();
    }

    @Override
    public List<?> countNumberOfRegisterUsersPeerMonth() {
        return utilisateurRepository.countNumberOfRegisterUserByMonth();
    }

    @Override
    public void deleteUtilisateur(Long userId) {
        if (userId == null) {
            log.error("Utilisateur not found");
            return;
        }
        utilisateurRepository.deleteById(userId);
    }
}
