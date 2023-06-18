package com.flowers.dtos;

import com.flowers.models.Subcategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDto {

    private Long id;

    @NotNull
    private String subCategoryName;

    private String description;

    @NotNull
    private CategoryDto categoryDto;

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

    public static SubCategoryDto fromEntityToDto(Subcategory subcategory) {
        if (subcategory == null) {
            return null;
        }
        return SubCategoryDto.builder()
                .id(subcategory.getId())
                .subCategoryName(subcategory.getSubCategoryName())
                .description(subcategory.getDescription())
                .actif(subcategory.getActif())
                .categoryDto(CategoryDto.fromEntityToDto(subcategory.getCategory()))
                .build();
    }

    public static Subcategory fromDtoToEntity(SubCategoryDto subCategoryDto) {
        if (subCategoryDto == null) {
            return null;
        }
        Subcategory subcategory = new Subcategory();
        subcategory.setId(subCategoryDto.getId());
        subcategory.setSubCategoryName(subCategoryDto.getSubCategoryName());
        subcategory.setDescription(subCategoryDto.getDescription());
        subcategory.setActif(subCategoryDto.isActif());
        subcategory.setCategory(CategoryDto.fromDtoToEntity(subCategoryDto.getCategoryDto()));
        return subcategory;
    }
}
