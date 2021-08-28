package com.flowers.controllers;

import com.flowers.controllers.api.CategoryApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Category;
import com.flowers.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;


    @Override
    public ResponseEntity<Category> saveCategory(Category category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long catId, Category category) {
        category.setId(catId);
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @Override
    public ResponseEntity<Category> getCategoryById(Long catId) throws ResourceNotFoundException {
        Category category = categoryService.findCategoryById(catId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return ResponseEntity.ok().body(category);
    }

    @Override
    public ResponseEntity<Category> getCategoryByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<Category> getCategoryByDesignation(String designation) {
        return null;
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @Override
    public ResponseEntity<List<Category>> getListCategoriesByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<List<Category>> getListCategoriesByDesignation(String designation) {
        return null;
    }

    @Override
    public void deleteCategory(Long catId) {
        categoryService.deleteCategory(catId);
    }
}
