package com.flowers.services;

import com.flowers.models.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {

    List<Subcategory> findAllSubcategories();

    Optional<Subcategory> findSubcategoryById(Long subCatId);

    Subcategory findByCode(String code);

    List<Subcategory> findListSubcategoryByCode(String code);

    Subcategory findByLibelle(String libelle);

    List<Subcategory> findListSubcategoryByLibelle(String libelle);

    List<Subcategory> findSubcategoryByCateoryId(Long subCatId);

    Subcategory saveSubcategory(Subcategory Subcategory);

    Subcategory updateSubcategory(Long subCatId, Subcategory subcategory);

    void deleteSubcategory(Long subCatId);


}
