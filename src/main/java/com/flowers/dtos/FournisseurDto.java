package com.flowers.dtos;

import com.flowers.models.Fournisseur;
import com.flowers.models.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurDto {

    private Long id;

    private String reference;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String email;

    @NotNull
    private String telephone;

    private String subject;

    private String message;

    @NotNull
    private ProductDto productDto;

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
                          String email, String telephone,
                          ProductDto productDto) {
        this.id = id;
        this.reference = reference;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.productDto = productDto;
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
                .subject(fournisseur.getSubject())
                .message(fournisseur.getMessage())
                .actif(fournisseur.getActif())
                .productDto(ProductDto.fromEntityToDto(fournisseur.getProduct()))
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
        fournisseur.setSubject(fournisseurDto.getSubject());
        fournisseur.setMessage(fournisseurDto.getMessage());
        fournisseur.setActif(fournisseurDto.isActif());
        fournisseur.setProduct(ProductDto.fromDtoToEntity(fournisseurDto.getProductDto()));
        fournisseur.setState(StateDto.fromDtoToEntity(fournisseurDto.getStateDto()));
        return fournisseur;
    }
}
