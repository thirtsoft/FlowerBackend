package com.flowers.controllers;

import com.flowers.controllers.api.SubcategoryApi;
import com.flowers.models.Subcategory;
import com.flowers.services.SubcategoryService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubcategoryController implements SubcategoryApi {

    private final SubcategoryService subcategoryService;

    @ApiResponses({
            @ApiResponse(code = 201, message = "La Scategory a été crée"),
            @ApiResponse(code = 400, message = "Aucun Scategory  crée / modifié")
    })
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
