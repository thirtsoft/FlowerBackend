package com.flowers.controllers;

import com.flowers.controllers.api.SubcategoryApi;
import com.flowers.dtos.SubCategoryDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.State;
import com.flowers.models.Subcategory;
import com.flowers.services.SubcategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SubcategoryController implements SubcategoryApi {

    private final SubcategoryService subcategoryService;


    @Override
    public ResponseEntity<SubCategoryDto> saveSubCategory(SubCategoryDto subCategoryDto) {
        return null;
    }

    @Override
    public ResponseEntity<SubCategoryDto> update(Long id, SubCategoryDto subCategoryDto) {
        return null;
    }

    @Override
    public ResponseEntity<SubCategoryDto> getSubcategoryById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<SubCategoryDto>> getAllSubcategories() {
        return null;
    }

    @Override
    public ResponseEntity<List<SubCategoryDto>> getAllSubcategoriesOrderByIdDesc() {
        return null;
    }

    @Override
    public ResponseEntity<List<SubCategoryDto>> getSubcategoryByCategoryId(Long catId) {
        return null;
    }

    @Override
    public void delete(Long id) {
        subcategoryService.deleteSubcategory(id);
    }
}
