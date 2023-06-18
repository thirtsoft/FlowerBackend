package com.flowers.services;

import com.flowers.dtos.BlogDto;
import com.flowers.dtos.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDto> findAllCategories();

    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto findCategoryById(Long catId);

    CategoryDto updateCategory(Long catId, CategoryDto categoryDto);

    List<CategoryDto> findCategoryByOrderByIdDesc();

    void delete(Long catId);

    List<CategoryDto> findAllActiveCategories();

    void deleteCategory(Long catId);


}
