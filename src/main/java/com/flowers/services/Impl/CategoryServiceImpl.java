package com.flowers.services.Impl;

import com.flowers.models.Category;
import com.flowers.reposiory.CategoryRepository;
import com.flowers.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return null;
    }

    @Override
    public Category saveCategory(Category category) {
        return null;
    }

    @Override
    public Optional<Category> findCategoryById(Long catId) {
        return Optional.empty();
    }

    @Override
    public Category updateCategory(Long catId, Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Long catId) {

    }

    @Override
    public Category findByCode(String code) {
        return null;
    }

    @Override
    public Category findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<Category> ListCategoryByCode(String designation) {
        return null;
    }

    @Override
    public List<Category> ListCategoryByDesignation(String designation) {
        return null;
    }
}
