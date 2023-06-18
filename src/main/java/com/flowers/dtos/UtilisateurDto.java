package com.flowers.dtos;

import com.flowers.models.Role;
import com.flowers.models.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto {

    private Long id;

    private String name;

    private String username;

    private String mobile;

    private String email;

    private String password;

    private String photo = "avatar.jpg";

    private boolean isActive;

    private Date createdDate;

    private Set<Role> roles = new HashSet<>();

    private int actif;

    public void setActif(boolean actif) {
        if (actif == true)
            this.actif = 1;
        else
            this.actif = 0;
    }

    public boolean isActif() {
        if (actif == 1)
            return true;
        else
            return false;
    }

    public UtilisateurDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public static UtilisateurDto fromEntityToDto(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .name(utilisateur.getName())
                .username(utilisateur.getUsername())
                .mobile(utilisateur.getMobile())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .photo(utilisateur.getPhoto())
                .isActive(utilisateur.isActive())
                .createdDate(utilisateur.getCreatedDate())
                .roles(utilisateur.getRoles())
                .actif(utilisateur.getActif())
                .build();

    }

    public static Utilisateur fromDtoToEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setName(utilisateurDto.getName());
        utilisateur.setUsername(utilisateurDto.getUsername());
        utilisateur.setMobile(utilisateurDto.getMobile());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setPassword(utilisateurDto.getPassword());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setActive(utilisateurDto.isActive());
        utilisateur.setCreatedDate(utilisateurDto.getCreatedDate());
        utilisateur.setRoles(utilisateur.getRoles());
        utilisateur.setActif(utilisateurDto.isActif());
        return utilisateur;
    }

}
