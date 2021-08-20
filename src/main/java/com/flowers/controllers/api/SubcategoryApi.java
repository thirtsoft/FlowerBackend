package com.flowers.controllers.api;

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
    @ApiOperation(value = "Enregistrer un Scategory",
            notes = "Cette méthode permet d'ajouter une Scategory", response = Subcategory.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Scategory a été crée"),
            @ApiResponse(code = 400, message = "Aucun Scategory  crée / modifié")
    })
    ResponseEntity<Subcategory> save(@RequestBody Subcategory subcategory);

    @PutMapping(value = APP_ROOT + "/subcategories/update/{idSubcategory}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Scategory par son ID",
            notes = "Cette méthode permet de modifier une Scategory par son ID", response = Subcategory.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Scategory a été modifiée"),
            @ApiResponse(code = 400, message = "La Scategory a n'est pas modifiée")
    })
    ResponseEntity<Subcategory> update(@PathVariable("idSubcategory") Long id, @RequestBody Subcategory subcategory);


    @GetMapping(value = APP_ROOT + "/subcategories/{idSubcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Scategory par ID",
            notes = "Cette méthode permet de chercher une Scategory par son ID", response = Subcategory.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Scategory a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Scategory n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<Subcategory> findById(@PathVariable("idSubcategory") Long id);

    @GetMapping(value = APP_ROOT + "/subcategories/searchbyLibelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Scategory par Libelle",
            notes = "Cette méthode permet de chercher une Scategory par son Libelle", response = Subcategory.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Scategory a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Scategory n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<Subcategory> findByLibelle(@PathVariable("libelle") String libelle);

    @GetMapping(value = APP_ROOT + "/subcategories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Scategories",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Scategories", responseContainer = "List<Subcategory>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Scategories / une liste vide")
    })
    List<Subcategory> findAll();

    @DeleteMapping(value = APP_ROOT + "/subcategories/delete/{idSubcategory}")
    @ApiOperation(value = "Supprimer un Scategory par son ID",
            notes = "Cette méthode permet de supprimer une Scategory par son ID", response = Subcategory.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Scategory a été supprimé")
    })
    void delete(@PathVariable("idSubcategory") Long id);
}
