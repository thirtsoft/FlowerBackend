package com.flowers.services;

import com.flowers.models.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {

    List<Subcategory> findAllSubcategories();

    Optional<Subcategory> findSubcategoryById(Long subCatId);

    Subcategory saveSubcategory(Subcategory subcategory);

    Subcategory updateSubcategory(Long subCatId, Subcategory subcategory);

    List<Subcategory> findSubcategoryByCateoryId(Long catId);

    void deleteSubcategory(Long subCatId);


}
