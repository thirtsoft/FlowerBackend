package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
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
        return subcategoryRepository.findAll();
    }

    @Override
    public Optional<Subcategory> findSubcategoryById(Long subCatId) {
        if (!subcategoryRepository.existsById(subCatId)) {
            throw new ResourceNotFoundException("SubCategory that id is " + subCatId + "not found");
        }
        return subcategoryRepository.findById(subCatId);
    }


    @Override
    public Subcategory saveSubcategory(Subcategory subcategory) {
        if (subcategory.getSubCategoryName() != null) {
            throw new ResourceNotFoundException("Subcategory already exists");
        }
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public Subcategory updateSubcategory(Long subCatId, Subcategory subcategory) {
        subcategory.setId(subCatId);
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public List<Subcategory> findSubcategoryByCateoryId(Long catId) {
        return subcategoryRepository.findSubcategoryByCateoryId(catId);
    }

    @Override
    public void deleteSubcategory(Long subCatId) {
        if (!subcategoryRepository.existsById(subCatId)) {
            throw new ResourceNotFoundException("Subcategory not found");
        }
        subcategoryRepository.deleteById(subCatId);

    }
}
