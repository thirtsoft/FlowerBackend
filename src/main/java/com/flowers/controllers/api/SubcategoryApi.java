package com.flowers.controllers.api;

import com.flowers.models.Subcategory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface SubcategoryApi {

    @PostMapping(value = APP_ROOT + "/subcategories/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
   /* @ApiOperation(value = "Enregistrer un Subcategory",
            notes = "Cette méthode permet d'ajouter une Subcategory", response = Subcategory.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Subcategory a été crée"),
            @ApiResponse(code = 400, message = "Aucun Subcategory  crée / modifié")
    })*/
    ResponseEntity<Subcategory> save(@RequestBody Subcategory Subcategory);

    @PutMapping(value = APP_ROOT + "/subcategories/update/{idSubcategory}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    /*
    @ApiOperation(value = "Modifier une Subcategory par son ID",
            notes = "Cette méthode permet de modifier une Subcategory par son ID", response = Subcategory.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été modifiée"),
            @ApiResponse(code = 400, message = "La Subcategory a n'est pas modifiée")
    })
    */
    ResponseEntity<Subcategory> update(@PathVariable("idSubcategory") Long id, @RequestBody Subcategory Subcategory);


    @GetMapping(value = APP_ROOT + "/subcategories/{idSubcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    /*
    @ApiOperation(value = "Rechercher une Subcategory par ID",
            notes = "Cette méthode permet de chercher une Subcategory par son ID", response = Subcategory.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Subcategory n'existe avec cette ID pas dans la BD")
    })*/
    ResponseEntity<Subcategory> findById(@PathVariable("idSubcategory") Long id);

    @GetMapping(value = APP_ROOT + "/subcategories/searchbyLibelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
    /*
    @ApiOperation(value = "Rechercher une Subcategory par Libelle",
            notes = "Cette méthode permet de chercher une Subcategory par son Libelle", response = Subcategory.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Subcategory n'existe avec cette ID pas dans la BD")
    })*/
    ResponseEntity<Subcategory> findByLibelle(@PathVariable("libelle") String libelle);

    @GetMapping(value = APP_ROOT + "/subcategories/all", produces = MediaType.APPLICATION_JSON_VALUE)
   /* @ApiOperation(value = "Renvoi la liste des subcategories",
            notes = "Cette méthode permet de chercher et renvoyer la liste des subcategories", responseContainer = "List<Subcategory>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des subcategories / une liste vide")
    })*/
    List<Subcategory> findAll();

    @DeleteMapping(value = APP_ROOT + "/subcategories/delete/{idSubcategory}")
    /*
    @ApiOperation(value = "Supprimer un Subcategory par son ID",
            notes = "Cette méthode permet de supprimer une Subcategory par son ID", response = Subcategory.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Subcategory a été supprimé")
    })*/
    void delete(@PathVariable("idSubcategory") Long id);
}
