package com.flowers.services.Impl;

import com.flowers.dtos.CategoryDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Blog;
import com.flowers.models.Category;
import com.flowers.reposiory.CategoryRepository;
import com.flowers.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        categoryDto.setActif(true);
        return CategoryDto.fromEntityToDto(
                categoryRepository.save(
                        CategoryDto.fromDtoToEntity(categoryDto)
                )
        );
    }

    @Override
    public CategoryDto updateCategory(Long catId, CategoryDto categoryDto) {
        if (!categoryRepository.existsById(catId)) {
            throw new ResourceNotFoundException("Category not found");
        }

        Optional<Category> category = categoryRepository.findById(catId);

        if (!category.isPresent()) {
            throw new ResourceNotFoundException("Category not found");
        }

        CategoryDto categoryResult = CategoryDto.fromEntityToDto(category.get());

        categoryResult.setCategoryName(categoryDto.getCategoryName());
        categoryResult.setDescription(categoryDto.getDescription());

        return CategoryDto.fromEntityToDto(
                categoryRepository.save(
                        CategoryDto.fromDtoToEntity(categoryResult)
                )
        );

    }

    @Override
    public CategoryDto findCategoryById(Long catId) {
        if (catId == null) {
            log.error("Category Id is null");
            return null;
        }

        Optional<Category> category = categoryRepository.findById(catId);

        return Optional.of(CategoryDto.fromEntityToDto(category.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun categorie avec l'Id = " + catId + "n'a été trouvé")
        );
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> findCategoryByOrderByIdDesc() {
        return categoryRepository.findByOrderByIdDesc().stream()
                .map(CategoryDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long catId) {
        if (catId == null) {
            log.error("Category Id is null");
            return;
        }
        categoryRepository.deleteById(catId);
    }

    @Override
    public List<CategoryDto> findAllActiveCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Long catId) {
        if (catId == null) {
            log.error("Category Id is null");
            return;
        }
        Category category = categoryRepository.findById(catId).get();
        category.setActif(false);
        categoryRepository.save(category);
    }
}
