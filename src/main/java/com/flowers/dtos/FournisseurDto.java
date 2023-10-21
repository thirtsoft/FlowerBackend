package com.flowers.dtos;

import com.flowers.models.Fournisseur;
import com.flowers.models.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurDto {

    private Long id;

    @NotNull(message = "La reference du fournisseur ne doit pas etre null")
    @NotEmpty(message = "La reference du fournisseur ne doit pas etre vide")
    @NotBlank(message = "La reference du fournisseur ne doit pas avoir dd'espace vide")
    private String reference;

    @NotNull(message = "Le prenom du fournisseur ne doit pas etre null")
    @NotEmpty(message = "Le prenom du fournisseur ne doit pas etre vide")
    @NotBlank(message = "Le prenom du fournisseur ne doit pas avoir d'espace vide")
    private String firstName;

    @NotNull(message = "Le nom du fournisseur ne doit pas etre null")
    @NotEmpty(message = "Le nom du fournisseur ne doit pas etre vide")
    @NotBlank(message = "Le nom du fournisseur ne doit pas avoir d'espace vide")
    private String lastName;

    private String email;

    @NotNull(message = "Le téléphone wave du fournisseur ne doit pas etre null")
    @NotEmpty(message = "Le téléphone wave du fournisseur ne doit pas etre vide")
    @NotBlank(message = "Le téléphone wave du fournisseur ne doit pas avoir d'espace vide")
    private String telephone;

    @NotNull(message = "Le téléphone orange money du fournisseur ne doit pas etre null")
    @NotEmpty(message = "Le téléphone orange money du fournisseur ne doit pas etre vide")
    @NotBlank(message = "Le téléphone orange money du fournisseur ne doit pas avoir d'espace vide")
    private String telephone2;

    private String telephone3;

    @NotNull(message = "L'addresse du fournisseur ne doit pas etre null")
    @NotEmpty(message = "L'addresse du fournisseur ne doit pas etre vide")
    @NotBlank(message = "L'addresse du fournisseur ne doit pas avoir d'espace vide")
    private StateDto stateDto;

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

    public FournisseurDto(Long id, String reference, String firstName, String lastName,
                          String email, String telephone) {
        this.id = id;
        this.reference = reference;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
    }

    public static FournisseurDto fromEntityToDto(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .reference(fournisseur.getReference())
                .firstName(fournisseur.getFirstName())
                .lastName(fournisseur.getLastName())
                .email(fournisseur.getEmail())
                .telephone(fournisseur.getTelephone())
                .telephone2(fournisseur.getTelephone2())
                .telephone3(fournisseur.getTelephone3())
                .actif(fournisseur.getActif())
                .stateDto(StateDto.fromEntityToDto(fournisseur.getState()))
                .build();
    }

    public static Fournisseur fromDtoToEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setReference(fournisseurDto.getReference());
        fournisseur.setFirstName(fournisseurDto.getFirstName());
        fournisseur.setLastName(fournisseurDto.getLastName());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setTelephone(fournisseurDto.getTelephone());
        fournisseur.setTelephone2(fournisseurDto.getTelephone2());
        fournisseur.setTelephone3(fournisseurDto.getTelephone3());
        fournisseur.setActif(fournisseurDto.isActif());
        fournisseur.setState(StateDto.fromDtoToEntity(fournisseurDto.getStateDto()));
        return fournisseur;
    }
}
