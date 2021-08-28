package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
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
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        if (category.getCategoryName() != null) {
            throw new ResourceNotFoundException("Category alredy exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findCategoryById(Long catId) {
        if (!categoryRepository.existsById(catId)) {
            throw new ResourceNotFoundException("Category that id is" + catId + "is not found");
        }
        return categoryRepository.findById(catId);
    }

    @Override
    public Category updateCategory(Long catId, Category category) {
        if (!categoryRepository.existsById(catId)) {
            throw new ResourceNotFoundException("Category that id is" + catId + "is not found");
        }
        Optional<Category> optionalCategory = categoryRepository.findById(catId);

        if (!optionalCategory.isPresent()) {
            throw new ResourceNotFoundException("Category not found");
        }

        Category categoryResult = optionalCategory.get();
        categoryResult.setCategoryName(category.getCategoryName());
        categoryResult.setDescription(category.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long catId) {
        if (!categoryRepository.existsById(catId)) {
            throw new ResourceNotFoundException("Category that id is" + catId + "is not found");
        }
        categoryRepository.deleteById(catId);
    }

}
