package com.flowers.dtos;

import com.flowers.models.Subcategory;
import com.flowers.models.ZoneLivraison;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZoneLivraisonDto {

    private Long id;

    @NotNull(message = "Le libelle de zone ne doit pas etre vide")
    @NotEmpty(message = "Le libelle de zone ne doit pas etre vide")
    @NotBlank(message = "Le libelle de zone ne doit pas etre vide")
    private String libelle;

    private String prix_zone;

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

    public static ZoneLivraisonDto fromEntityToDto(ZoneLivraison zoneLivraison) {
        if (zoneLivraison == null) {
            return null;
        }
        return ZoneLivraisonDto.builder()
                .id(zoneLivraison.getId())
                .libelle(zoneLivraison.getLibelle())
                .prix_zone(zoneLivraison.getPrix_zone())
                .build();
    }

    public static ZoneLivraison fromDtoToEntity(ZoneLivraisonDto zoneLivraisonDto) {
        if (zoneLivraisonDto == null) {
            return null;
        }
        ZoneLivraison zoneLivraison = new ZoneLivraison();
        zoneLivraison.setId(zoneLivraisonDto.getId());
        zoneLivraison.setLibelle(zoneLivraisonDto.getLibelle());
        zoneLivraison.setPrix_zone(zoneLivraisonDto.getPrix_zone());
        return zoneLivraison;
    }
}