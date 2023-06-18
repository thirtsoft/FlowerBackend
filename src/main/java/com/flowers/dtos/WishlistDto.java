package com.flowers.dtos;

import com.flowers.models.Wishlist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDto {

    private Long id;

    private String reference;

    private String nbreEtoile;

    private String description;

    private String observation;

    private ProductDto productDto;

    private UtilisateurDto utilisateurDto;

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

    public static WishlistDto fromEntityToDto(Wishlist wishlist) {
        if (wishlist == null) {
            return null;
        }

        return WishlistDto.builder()
                .id(wishlist.getId())
                .reference(wishlist.getReference())
                .nbreEtoile(wishlist.getNombreEtoile())
                .observation(wishlist.getObservation())
                .description(wishlist.getDescription())
                .actif(wishlist.getActif())
                .productDto(ProductDto.fromEntityToDto(wishlist.getProduct()))
                .utilisateurDto(UtilisateurDto.fromEntityToDto(wishlist.getUtilisateur()))
                .build();
    }

    public static Wishlist fromDtoToEntity(WishlistDto wishlistDto) {
        if (wishlistDto == null) {
            return null;
        }

        Wishlist wishlist = new Wishlist();
        wishlist.setId(wishlistDto.getId());
        wishlist.setReference(wishlistDto.getReference());
        wishlist.setNombreEtoile(wishlistDto.getNbreEtoile());
        wishlist.setObservation(wishlistDto.getObservation());
        wishlist.setDescription(wishlistDto.getDescription());
        wishlist.setActif(wishlistDto.isActif());
        wishlist.setProduct(ProductDto.fromDtoToEntity(wishlistDto.getProductDto()));
        wishlist.setUtilisateur(UtilisateurDto.fromDtoToEntity(wishlistDto.getUtilisateurDto()));
        return wishlist;
    }


}
