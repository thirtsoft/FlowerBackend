package com.flowers.controllers;

import com.flowers.controllers.api.SubcategoryApi;
import com.flowers.dtos.SubCategoryDto;
import com.flowers.services.SubcategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SubcategoryController implements SubcategoryApi {

    private final SubcategoryService subcategoryService;


    @Override
    public ResponseEntity<SubCategoryDto> saveSubCategory(SubCategoryDto subCategoryDto) {
        SubCategoryDto subCategoryDtoResult = subcategoryService.saveSubcategory(subCategoryDto);
        return new ResponseEntity<>(subCategoryDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SubCategoryDto> update(Long id, SubCategoryDto subCategoryDto) {
        subCategoryDto.setId(id);
        SubCategoryDto subCategoryDtoResult = subcategoryService.saveSubcategory(subCategoryDto);
        return new ResponseEntity<>(subCategoryDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubCategoryDto> getSubcategoryById(Long id) {
        SubCategoryDto subCategoryDtoResult = subcategoryService.findSubcategoryById(id);
        return new ResponseEntity<>(subCategoryDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SubCategoryDto>> getAllSubcategories() {
        List<SubCategoryDto> subCategoryDtoList = subcategoryService.findAllSubcategories();
        return new ResponseEntity<>(subCategoryDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SubCategoryDto>> getAllSubcategoriesOrderByIdDesc() {
        List<SubCategoryDto> subCategoryDtoList = subcategoryService.findSubcategoryByOrderByIdDesc();
        return new ResponseEntity<>(subCategoryDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SubCategoryDto>> getSubcategoryByCategoryId(Long catId) {
        List<SubCategoryDto> subCategoryDtoList = subcategoryService.findSubcategoryByCategoryId(catId);
        return new ResponseEntity<>(subCategoryDtoList, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        subcategoryService.deleteSubcategory(id);
    }
}
