package com.flowers.dtos;

import com.flowers.models.Product;
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
public class ProductDto {

    private Long id;

    @NotNull
    private String reference;

    @NotNull
    private String designation;

    private int quantity;

    private int quantite;

    @NotNull
    private double price;

    @NotNull
    private double currentPrice;

    private boolean promo;

    private boolean selected;

    @NotNull
    private String description;

    private String manufactured;

    @NotNull
    private String photo;

    @NotNull(message = "La sous-catégorie de l'article ne doit pas etre vide")
    @NotEmpty(message = "La sous-catégorie de l'article ne doit pas etre vide")
    @NotBlank(message = "La sous-catégorie de l'article ne doit pas etre vide")
    private SubCategoryDto subCategoryDto;

    @NotNull(message = "Le fournisseur de l'article ne doit pas etre vide")
    @NotEmpty(message = "Le fournisseur de l'article ne doit pas etre vide")
    @NotBlank(message = "Le fournisseur de l'article ne doit pas etre vide")
    private FournisseurDto fournisseurDto;

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

    public ProductDto(long id, String reference, String designation, int quantity,
                      double price, double currentPrice, boolean promo, boolean selected,
                      String description, String photo, SubCategoryDto subCategoryDto) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.quantity = quantity;
        this.price = price;
        this.currentPrice = currentPrice;
        this.promo = promo;
        this.selected = selected;
        this.description = description;
        this.photo = photo;
        this.subCategoryDto = subCategoryDto;
    }

    public ProductDto(Long id, String reference, String designation,
                      int quantity, int quantite, double price, String description,
                      boolean selected,
                      String photo, SubCategoryDto subCategoryDto) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.quantity = quantity;
        this.quantite = quantite;
        this.price = price;
        this.selected = selected;
        this.description = description;
        this.photo = photo;
        this.subCategoryDto = subCategoryDto;
    }

    public static ProductDto fromEntityToDto(Product product) {
        if (product == null) {
            return null;
        }
        return ProductDto.builder()
                .id(product.getId())
                .reference(product.getReference())
                .designation(product.getDesignation())
                .quantity(product.getQuantity())
                .quantite(product.getQuantite())
                .price(product.getPrice())
                .currentPrice(product.getCurrentPrice())
                .promo(product.isPromo())
                .selected(product.isSelected())
                .description(product.getDescription())
                .manufactured(product.getManufactured())
                .photo(product.getImageUrl())
                .actif(product.getActif())
                .subCategoryDto(SubCategoryDto.fromEntityToDto(product.getSubcategory()))
                .fournisseurDto(FournisseurDto.fromEntityToDto(product.getFournisseur()))
                .build();
    }

    public static Product fromDtoToEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setReference(productDto.getReference());
        product.setDesignation(productDto.getDesignation());
        product.setQuantity(productDto.getQuantity());
        product.setQuantite(productDto.getQuantite());
        product.setPrice(productDto.getPrice());
        product.setCurrentPrice(productDto.getCurrentPrice());
        product.setPromo(productDto.isPromo());
        product.setSelected(productDto.isSelected());
        product.setDescription(productDto.getDescription());
        product.setManufactured(productDto.getManufactured());
        product.setImageUrl(productDto.getPhoto());
        product.setActif(productDto.isActif());
        product.setSubcategory(SubCategoryDto.fromDtoToEntity(productDto.getSubCategoryDto()));
        product.setFournisseur(FournisseurDto.fromDtoToEntity(productDto.getFournisseurDto()));
        return product;
    }
}
