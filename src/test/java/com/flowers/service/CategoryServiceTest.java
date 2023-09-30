package com.flowers.service;


import com.flowers.dtos.CategoryDto;
import com.flowers.models.Category;
import com.flowers.reposiory.CategoryRepository;
import com.flowers.services.Impl.CategoryServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void should_save_one_category() {
        Category category = new Category();
        category.setId(1L);
        category.setCategoryName("Fleur01");
        category.setDescription("Cat01");

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryDto categoryDto = categoryService.saveCategory(CategoryDto.fromEntityToDto(new Category()));

        Category categoryResult = CategoryDto.fromDtoToEntity(categoryDto);

        assertThat(categoryResult).usingRecursiveComparison().isEqualTo(category);
        verify(categoryRepository, times(1)).save(any(Category.class));
        verifyNoMoreInteractions(categoryRepository);
    }

    @Test
    public void should_find_and_return_one_category() {
        Category category = new Category();
        category.setId(2L);
        category.setCategoryName("Fleur02");
        category.setDescription("Cat02");

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));

        CategoryDto categoryDtoResult = categoryService.findCategoryById(anyLong());

        Category categoryResult = CategoryDto.fromDtoToEntity(categoryDtoResult);

        assertThat(categoryResult).usingRecursiveComparison().isEqualTo(category);
        verify(categoryRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(categoryRepository);
    }

    @Test
    public void should_update_category() {
        Category category = new Category();
        category.setId(3L);
        category.setCategoryName("Fleur03");
        category.setDescription("Cat03");

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));

        CategoryDto categoryDtoResult = categoryService.findCategoryById(anyLong());
        categoryDtoResult.setCategoryName("Cat002");
        categoryService.saveCategory(categoryDtoResult);

        Category categoryResult = CategoryDto.fromDtoToEntity(categoryDtoResult);

        assertThat(categoryResult).usingRecursiveComparison().isNotEqualTo(category);
        assertThat(categoryResult.getCategoryName()).isEqualTo("Cat002");

    }


    @Test
    public void should_find_and_return_all_categories() {
        Category category = new Category();
        category.setId(4L);
        category.setCategoryName("Fleur04");
        category.setDescription("Cat04");

        when(categoryRepository.findAll()).thenReturn(singletonList(category));

        List<CategoryDto> categoryList = categoryService.findAllActiveCategories();

        assertThat(categoryList).isNotNull();
        assertThat(categoryList).hasSize(1);
        verify(categoryRepository, times(1)).findAll();
        verifyNoMoreInteractions(categoryRepository);
    }

    @Test
    public void should_delete_one_category() {
        doNothing().when(categoryRepository).deleteById(anyLong());

        categoryService.deleteCategory(anyLong());
        verify(categoryRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(categoryRepository);
    }


}
