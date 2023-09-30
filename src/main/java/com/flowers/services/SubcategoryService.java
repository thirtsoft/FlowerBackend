package com.flowers.services;

import com.flowers.dtos.SubCategoryDto;

import java.util.List;

public interface SubcategoryService {

    SubCategoryDto findSubcategoryById(Long subCatId);

    SubCategoryDto saveSubcategory(SubCategoryDto subCategoryDto);

    SubCategoryDto updateSubcategory(Long subCatId, SubCategoryDto subCategoryDto);

    List<SubCategoryDto> findSubcategoryByCategoryId(Long catId);

    List<SubCategoryDto> findAllActiveSubCategories();

    void deleteSubcategory(Long subcatId);
}
