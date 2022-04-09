package com.flowers.controllers.api;

import com.flowers.dtos.SubCategoryDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Subcategory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface SubcategoryApi {

    @PostMapping(value = APP_ROOT + "/subcategories/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Subcategory",
            notes = "Cette méthode permet d'ajouter une Subcategory", response = SubCategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Subcategory a été crée"),
            @ApiResponse(code = 400, message = "Aucun Scategory  crée / modifié")
    })
    ResponseEntity<SubCategoryDto> saveSubCategory(@RequestBody SubCategoryDto subCategoryDto);

    @PutMapping(value = APP_ROOT + "/subcategories/update/{subCatId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Subcategory par son ID",
            notes = "Cette méthode permet de modifier une Subcategory par son ID", response = SubCategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été modifiée"),
            @ApiResponse(code = 400, message = "La Subcategory a n'est pas modifiée")
    })
    ResponseEntity<SubCategoryDto> update(@PathVariable("subCatId") Long id, @RequestBody SubCategoryDto subCategoryDto);

    @GetMapping(value = APP_ROOT + "/subcategories/findById/{subCatId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Subcategory par ID",
            notes = "Cette méthode permet de chercher une Subcategory par son ID", response = SubCategoryDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Subcategory n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<SubCategoryDto> getSubcategoryById(@PathVariable("subCatId") Long id);

    @GetMapping(value = APP_ROOT + "/subcategories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Subcategory",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Scategories", responseContainer = "List<SubCategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Subcategory / une liste vide")
    })
    ResponseEntity<List<SubCategoryDto>> getAllSubcategories();

    @GetMapping(value = APP_ROOT + "/subcategories/searchAllSubCategoriesOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Subcategory par ordre decroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Scategories par ordre decroissante", responseContainer = "List<SubCategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Subcategory / une liste vide")
    })
    ResponseEntity<List<SubCategoryDto>> getAllSubcategoriesOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/subcategories/searchSubcategoryByCategoryId/{catId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Subcategory par category",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Scategories par category", responseContainer = "List<SubCategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Subcategory / une liste vide")
    })
    ResponseEntity<List<SubCategoryDto>> getSubcategoryByCategoryId(@PathVariable("catId") Long catId);

    @DeleteMapping(value = APP_ROOT + "/subcategories/delete/{subCatId}")
    @ApiOperation(value = "Supprimer un Subcategory par son ID",
            notes = "Cette méthode permet de supprimer une Scategory par son ID", response = SubCategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été supprimé")
    })
    void delete(@PathVariable("subCatId") Long id);
}
