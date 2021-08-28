package com.flowers.services;

import com.flowers.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAllCategories();

    Category saveCategory(Category category);

    Optional<Category> findCategoryById(Long catId);

    Category updateCategory(Long catId, Category category);

    void deleteCategory(Long catId);


}
