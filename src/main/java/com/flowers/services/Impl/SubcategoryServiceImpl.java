package com.flowers.services.Impl;

import com.flowers.models.Subcategory;
import com.flowers.reposiory.SubcategoryRepository;
import com.flowers.services.SubcategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    @Override
    public List<Subcategory> findAllSubcategories() {
        return null;
    }

    @Override
    public Optional<Subcategory> findSubcategoryById(Long subCatId) {
        return Optional.empty();
    }

    @Override
    public Subcategory findByCode(String code) {
        return null;
    }

    @Override
    public List<Subcategory> findListSubcategoryByCode(String code) {
        return null;
    }

    @Override
    public Subcategory findByLibelle(String libelle) {
        return null;
    }

    @Override
    public List<Subcategory> findListSubcategoryByLibelle(String libelle) {
        return null;
    }

    @Override
    public List<Subcategory> findSubcategoryByCateoryId(Long subCatId) {
        return null;
    }

    @Override
    public Subcategory saveSubcategory(Subcategory Subcategory) {
        return null;
    }

    @Override
    public Subcategory updateSubcategory(Long subCatId, Subcategory subcategory) {
        return null;
    }

    @Override
    public void deleteSubcategory(Long subCatId) {

    }
}
