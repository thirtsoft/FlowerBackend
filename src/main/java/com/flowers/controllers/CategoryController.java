package com.flowers.controllers;

import com.flowers.controllers.api.CategoryApi;
import com.flowers.dtos.CategoryDto;
import com.flowers.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"https://fleurpourtous.com", "https://portail.fleurpourtous.com"})
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;


    @Override
    public ResponseEntity<CategoryDto> saveCategory(CategoryDto categoryDto) {
        CategoryDto categoryDtoResult = categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(categoryDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(Long catId, CategoryDto categoryDto) {
        categoryDto.setId(catId);
        CategoryDto categoryDtoResult = categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(categoryDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById(Long catId) {
        CategoryDto categoryDtoResult = categoryService.findCategoryById(catId);
        return new ResponseEntity<>(categoryDtoResult, HttpStatus.OK);
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
        List<CategoryDto> categoryDtoList = categoryService.findAllCategories();
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategoriesOrderByIdDesc() {
        List<CategoryDto> categoryDtoList = categoryService.findCategoryByOrderByIdDesc();
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
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
    public void delete(Long catId) {
        categoryService.delete(catId);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllActiveCategories() {
        List<CategoryDto> categoryDtoList = categoryService.findAllActiveCategories();
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteCategory(Long catId) {
        categoryService.deleteCategory(catId);
    }
}
