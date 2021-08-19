package com.flowers.services;

import com.flowers.models.Category;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAllCategories();

    Category saveCategory(Category category);

    Optional<Category> findCategoryById(Long catId);

    Category updateCategory(Long catId, Category category);

    void deleteCategory(Long catId);

    Category findByCode(String code);

    Category findByDesignation(String designation);

    List<Category> ListCategoryByCode(String designation);

    List<Category> ListCategoryByDesignation(String designation);


}
