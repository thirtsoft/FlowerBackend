package com.flowers.dtos;

import com.flowers.models.Role;
import com.flowers.models.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Set<Role> roles = new HashSet<>();

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
                .roles(utilisateur.getRoles())
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
        utilisateur.setActive(utilisateur.isActive());
        utilisateur.setRoles(utilisateur.getRoles());

        return utilisateur;
    }

}
