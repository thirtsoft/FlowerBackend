package com.flowers.services;

import com.flowers.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAllActiveCategories();

    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto findCategoryById(Long catId);

    CategoryDto updateCategory(Long catId, CategoryDto categoryDto);

    void deleteCategory(Long catId);
}
