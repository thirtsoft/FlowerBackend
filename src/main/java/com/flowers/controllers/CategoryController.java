package com.flowers.controllers;

import com.flowers.controllers.api.CategoryApi;
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
        return null;
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long catId, Category category) {
        return null;
    }

    @Override
    public ResponseEntity<Category> findCategoryById(Long catId) {
        return null;
    }

    @Override
    public ResponseEntity<Category> findByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<Category> findByDesignation(String designation) {
        return null;
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        return null;
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

    }
}
