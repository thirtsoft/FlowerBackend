package com.flowers.controllers.api;

import com.flowers.dtos.CategoryDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;


@RequestMapping(value = APP_ROOT + "/categories")
public interface CategoryApi {

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Category",
            notes = "Cette méthode permet d'ajouter une Category", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Category a été crée"),
            @ApiResponse(code = 400, message = "Aucun Category  crée / modifié")
    })
    ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto);

    @PutMapping(value = "/update/{catId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Category par son ID",
            notes = "Cette méthode permet de modifier une Category par son ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Category a été modifiée"),
            @ApiResponse(code = 400, message = "La Category a n'est pas modifiée")
    })
    ResponseEntity<CategoryDto> updateCategory(@PathVariable(value = "catId") Long catId, @RequestBody CategoryDto categoryDto);

    @GetMapping(value = "/findById/{catId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Category par ID",
            notes = "Cette méthode permet de chercher une Category par son ID", response = CategoryDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Category a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Category n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable(value = "catId") Long catId);

    @GetMapping(value = "/search-all-active-categories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des categories actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des categories actives",
            responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des categories par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<CategoryDto>> getAllActiveCategories();

    @DeleteMapping(value = "/delete-category/{catId}")
    @ApiOperation(value = "Supprimer un categorie par son ID",
            notes = "Cette méthode permet de supprimer un categorie  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le categorie a été supprimé")
    })
    void deleteCategory(@PathVariable("catId") Long catId);

}
