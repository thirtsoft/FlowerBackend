package com.flowers.services;

import com.flowers.dtos.SubCategoryDto;
import com.flowers.models.State;
import com.flowers.models.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {

    List<SubCategoryDto> findAllSubcategories();

    SubCategoryDto findSubcategoryById(Long subCatId);

    SubCategoryDto saveSubcategory(SubCategoryDto subCategoryDto);

    SubCategoryDto updateSubcategory(Long subCatId, SubCategoryDto subCategoryDto);

    List<SubCategoryDto> findSubcategoryByCategoryId(Long catId);

    List<SubCategoryDto> findSubcategoryByOrderByIdDesc();

    void deleteSubcategory(Long subCatId);


}
