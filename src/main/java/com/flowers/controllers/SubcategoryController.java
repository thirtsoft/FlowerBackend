package com.flowers.controllers;

import com.flowers.controllers.api.SubcategoryApi;
import com.flowers.models.Subcategory;
import com.flowers.services.SubcategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubcategoryController implements SubcategoryApi {

    private final SubcategoryService subcategoryService;

    @Override
    public ResponseEntity<Subcategory> save(Subcategory subcategory) {
        return null;
    }

    @Override
    public ResponseEntity<Subcategory> update(Long id, Subcategory subcategory) {
        return null;
    }

    @Override
    public ResponseEntity<Subcategory> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Subcategory> findByLibelle(String libelle) {
        return null;
    }

    @Override
    public List<Subcategory> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
