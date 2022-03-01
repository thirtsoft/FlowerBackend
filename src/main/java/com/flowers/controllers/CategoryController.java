package com.flowers.controllers;

import com.flowers.controllers.api.CategoryApi;
import com.flowers.dtos.CategoryDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Blog;
import com.flowers.models.Category;
import com.flowers.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;


    @Override
    public ResponseEntity<CategoryDto> saveCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(Long catId, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById(Long catId) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryByDesignation(String designation) {
        return null;
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return null;
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategoriesOrderByIdDesc() {
        return null;
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getListCategoriesByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getListCategoriesByDesignation(String designation) {
        return null;
    }

    @Override
    public void deleteCategory(Long catId) {

    }
}
