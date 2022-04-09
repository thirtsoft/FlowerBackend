package com.flowers.dtos;

import com.flowers.models.LigneCommande;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeDto {

    private Long id;

    private int quantity;

    private double price;

    private Long productId;

    private String productName;

    // @JsonIgnore
    private CommandeDto commandeDto;

    private ProductDto productDto;

    public static LigneCommandeDto fromEntityToDto(LigneCommande ligneCommande) {
        if (ligneCommande == null) {
            return null;
        }

        return LigneCommandeDto.builder()
                .id(ligneCommande.getId())
                .quantity(ligneCommande.getQuantity())
                .price(ligneCommande.getPrice())
                .productId(ligneCommande.getProductId())
                .productName(ligneCommande.getProductName())
                .commandeDto(CommandeDto.fromEntityToDto(ligneCommande.getCommande()))
                .productDto(ProductDto.fromEntityToDto(ligneCommande.getProduct()))
                .build();
    }

    public static LigneCommande fromDtoToEntity(LigneCommandeDto ligneCommandeDto) {
        if (ligneCommandeDto == null) {
            return null;
        }

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(ligneCommandeDto.getId());
        ligneCommande.setQuantity(ligneCommandeDto.getQuantity());
        ligneCommande.setPrice(ligneCommandeDto.getPrice());
        ligneCommande.setProductId(ligneCommandeDto.getProductId());
        ligneCommande.setProductName(ligneCommande.getProductName());
        ligneCommande.setProduct(ProductDto.fromDtoToEntity(ligneCommandeDto.getProductDto()));
        ligneCommande.setCommande(CommandeDto.fromDtoToEntity(ligneCommandeDto.getCommandeDto()));

        return ligneCommande;
    }

}
