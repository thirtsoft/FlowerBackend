package com.flowers.services;

import com.flowers.dtos.SubCategoryDto;
import com.flowers.dtos.UtilisateurDto;
import com.flowers.enums.RoleName;
import com.flowers.models.Utilisateur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UtilisateurService {

    List<UtilisateurDto> findAllUtilisateurs();

    UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto);

    void addRoleToUser(String username, RoleName roleName);

    UtilisateurDto findUtilisateurById(Long userId);

    UtilisateurDto findByUsername(String username);

    UtilisateurDto updateUtilisateur(Long userId, UtilisateurDto utilisateurDto);

    List<UtilisateurDto> findUtilisateurByOrderByIdDesc();

    boolean updateUsernameOfUtilisateurByUsername(String username, String newUsername);

    boolean updateUsernameOfUtilisateurByUserId(String id, String newUsername);

    boolean updateCustomerPasswordByUsername(String username, String oldPass, String newPass);

    boolean updateCustomerPasswordByUserId(String id, String oldPass, String newPass);

    boolean updateCustomerProfileByUsername(String username, String name, String newUsername, String email, String mobile);

    UtilisateurDto activatedUser(String isActive, String id);

    BigDecimal countNumberOfRegisterInMonth();

    List<?> countNumberOfRegisterUsersPeerMonth();

    void delete(Long userId);

    List<UtilisateurDto> findAllActiveUtilisateurs();

    void deleteUtilisateur(Long userId);
}
