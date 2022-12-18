package com.flowers.service;


import com.flowers.dtos.SubCategoryDto;
import com.flowers.models.Category;
import com.flowers.models.Subcategory;
import com.flowers.reposiory.CategoryRepository;
import com.flowers.reposiory.SubcategoryRepository;
import com.flowers.services.Impl.SubcategoryServiceImpl;
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
public class SubCategoryServiceTest {

    @InjectMocks
    private SubcategoryServiceImpl subcategoryService;

    @Mock
    private SubcategoryRepository subcategoryRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void should_save_one_subcategory() {
        Category category = new Category();
        category.setCategoryName("Cat01");
        category.setDescription("Cat01");
        categoryRepository.save(category);
        Subcategory subcategory = new Subcategory();
        subcategory.setId(1L);
        subcategory.setSubCategoryName("Sucat01");
        subcategory.setDescription("Subcat01");
        subcategory.setCategory(category);

        when(subcategoryRepository.save(any(Subcategory.class))).thenReturn(subcategory);

        SubCategoryDto subcategoryDto = subcategoryService.saveSubcategory(SubCategoryDto.fromEntityToDto(new Subcategory()));

        Subcategory subcategoryResult = SubCategoryDto.fromDtoToEntity(subcategoryDto);

        assertThat(subcategoryResult).usingRecursiveComparison().isEqualTo(subcategory);
        verify(subcategoryRepository, times(1)).save(any(Subcategory.class));
        verifyNoMoreInteractions(subcategoryRepository);
    }

    @Test
    public void should_find_and_return_one_subcategory() {
        Category category = new Category();
        category.setCategoryName("Cat02");
        category.setDescription("Cat02");
        categoryRepository.save(category);
        Subcategory subcategory = new Subcategory();
        subcategory.setId(2L);
        subcategory.setSubCategoryName("Sucat02");
        subcategory.setDescription("Subcat02");
        subcategory.setCategory(category);

        when(subcategoryRepository.findById(anyLong())).thenReturn(Optional.of(subcategory));

        SubCategoryDto subcategoryDtoResult = subcategoryService.findSubcategoryById(anyLong());

        Subcategory subcategoryResult = SubCategoryDto.fromDtoToEntity(subcategoryDtoResult);

        assertThat(subcategoryResult).usingRecursiveComparison().isEqualTo(subcategory);
        verify(subcategoryRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(subcategoryRepository);
    }

    @Test
    public void should_update_subcategory() {
        Category category = new Category();
        category.setCategoryName("Cat03");
        category.setDescription("Cat03");
        categoryRepository.save(category);
        Subcategory subcategory = new Subcategory();
        subcategory.setId(3L);
        subcategory.setSubCategoryName("Sucat03");
        subcategory.setDescription("Subcat03");
        subcategory.setCategory(category);

        when(subcategoryRepository.findById(anyLong())).thenReturn(Optional.of(subcategory));

        SubCategoryDto subcategoryDtoResult = subcategoryService.findSubcategoryById(anyLong());
        subcategoryDtoResult.setSubCategoryName("Bignona");
        subcategoryService.saveSubcategory(subcategoryDtoResult);

        Subcategory subcategoryResult = SubCategoryDto.fromDtoToEntity(subcategoryDtoResult);

        assertThat(subcategoryResult).usingRecursiveComparison().isNotEqualTo(subcategory);
        assertThat(subcategoryResult.getSubCategoryName()).isEqualTo("Bignona");

    }


    @Test
    public void should_find_and_return_all_subcategories() {
        Subcategory subcategory = new Subcategory();
        subcategory.setId(4L);
        subcategory.setSubCategoryName("Sucat04");
        subcategory.setDescription("Subcat04");

        when(subcategoryRepository.findAll()).thenReturn(singletonList(subcategory));

        List<SubCategoryDto> subcategoryList = subcategoryService.findAllSubcategories();

        assertThat(subcategoryList).isNotNull();
        assertThat(subcategoryList).hasSize(1);
        verify(subcategoryRepository, times(1)).findAll();
        verifyNoMoreInteractions(subcategoryRepository);
    }

    @Test
    public void should_find_and_return_all_subcategories_by_Id_desc() {
        Subcategory subcategory = new Subcategory();
        subcategory.setId(5L);
        subcategory.setSubCategoryName("Sucat05");
        subcategory.setDescription("Subcat05");

        when(subcategoryRepository.findByOrderByIdDesc()).thenReturn(singletonList(subcategory));

        List<SubCategoryDto> subcategoryList = subcategoryService.findSubcategoryByOrderByIdDesc();

        assertThat(subcategoryList).isNotNull();
        assertThat(subcategoryList).hasSize(1);
        verify(subcategoryRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(subcategoryRepository);
    }

    @Test
    public void should_find_and_return_all_subcategories_by_category_id() {
        Long catId = 1L;
        when(subcategoryRepository.findSubcategoryByCategoryId(catId)).thenReturn(singletonList(any()));

        List<SubCategoryDto> subcategoryList = subcategoryService.findSubcategoryByCategoryId(catId);

        assertThat(subcategoryList).isNotNull();
        assertThat(subcategoryList).hasSize(1);
        verify(subcategoryRepository, times(1)).findSubcategoryByCategoryId(catId);
        verifyNoMoreInteractions(subcategoryRepository);
    }


    @Test
    public void should_delete_one_subcategory() {
        doNothing().when(subcategoryRepository).deleteById(anyLong());

        subcategoryService.deleteSubcategory(anyLong());
        verify(subcategoryRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(subcategoryRepository);
    }


}
