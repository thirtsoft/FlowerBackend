package com.flowers.controllers.api;

import com.flowers.dtos.SubCategoryDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/subcategories")
public interface SubcategoryApi {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Subcategory",
            notes = "Cette méthode permet d'ajouter une Subcategory", response = SubCategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Subcategory a été crée"),
            @ApiResponse(code = 400, message = "Aucun Scategory  crée / modifié")
    })
    ResponseEntity<SubCategoryDto> saveSubCategory(@RequestBody SubCategoryDto subCategoryDto);

    @PutMapping(value = "/update/{subCatId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Subcategory par son ID",
            notes = "Cette méthode permet de modifier une Subcategory par son ID", response = SubCategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été modifiée"),
            @ApiResponse(code = 400, message = "La Subcategory a n'est pas modifiée")
    })
    ResponseEntity<SubCategoryDto> update(@PathVariable("subCatId") Long id, @RequestBody SubCategoryDto subCategoryDto);

    @GetMapping(value = "/findById/{subCatId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Subcategory par ID",
            notes = "Cette méthode permet de chercher une Subcategory par son ID", response = SubCategoryDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Subcategory n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<SubCategoryDto> getSubcategoryById(@PathVariable("subCatId") Long id);

    @GetMapping(value = "/search-subcategories-by-categoryId/{catId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Subcategory par category",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Scategories par category", responseContainer = "List<SubCategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Subcategory / une liste vide")
    })
    ResponseEntity<List<SubCategoryDto>> getSubcategoryByCategoryId(@PathVariable("catId") Long catId);

    @GetMapping(value = "/search-all-active-subcategories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des subcategories actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des subcategories actives",
            responseContainer = "List<SubCategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des subcategories par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<SubCategoryDto>> getAllActiveSubCategories();

    @DeleteMapping(value = "/delete-subcategory/{subCatId}")
    @ApiOperation(value = "Supprimer un subcategories par son ID",
            notes = "Cette méthode permet de supprimer un subcategories  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le subcategories a été supprimé")
    })
    void deleteSubcategory(@PathVariable("subCatId") Long subCatId);
}