package com.flowers.controllers;

import com.flowers.controllers.api.SubcategoryApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.State;
import com.flowers.models.Subcategory;
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
    public ResponseEntity<Subcategory> save(Subcategory subcategory) {
        return ResponseEntity.ok(subcategoryService.saveSubcategory(subcategory));
    }

    @Override
    public ResponseEntity<Subcategory> update(Long id, Subcategory subcategory) {
        subcategory.setId(id);
        return ResponseEntity.ok(subcategoryService.saveSubcategory(subcategory));
    }

    @Override
    public ResponseEntity<Subcategory> getSubcategoryById(Long id) throws ResourceNotFoundException {
        Subcategory subcategory = subcategoryService.findSubcategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subcategory not found"));
        return ResponseEntity.ok().body(subcategory);
    }

    @Override
    public ResponseEntity<List<Subcategory>> getAllSubcategories() {
        return ResponseEntity.ok(subcategoryService.findAllSubcategories());
    }

    @Override
    public ResponseEntity<List<Subcategory>> getAllSubcategoriesOrderByIdDesc() {
        List<Subcategory> subcategoryList = subcategoryService.findSubcategoryByOrderByIdDesc();
        return new ResponseEntity<>(subcategoryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Subcategory>> getSubcategoryByCategoryId(Long catId) {
        return ResponseEntity.ok(subcategoryService.findSubcategoryByCategoryId(catId));
    }

    @Override
    public void delete(Long id) {
        subcategoryService.deleteSubcategory(id);
    }
}
