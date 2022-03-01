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

    public static SubCategoryDto fromEntityToDto(Subcategory subcategory) {
        if (subcategory == null) {
            return null;
        }
        return SubCategoryDto.builder()
                .id(subcategory.getId())
                .subCategoryName(subcategory.getSubCategoryName())
                .description(subcategory.getDescription())
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
        subcategory.setCategory(CategoryDto.fromDtoToEntity(subCategoryDto.getCategoryDto()));

        return subcategory;
    }
}
