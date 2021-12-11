package com.flowers.controllers.api;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Category;
import com.flowers.models.Country;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface CountryApi {

    @PostMapping(value = APP_ROOT + "/countries/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un countrie",
            notes = "Cette méthode permet d'ajouter une countrie", response = Country.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Country a été crée"),
            @ApiResponse(code = 400, message = "Aucun Country  crée / modifié")
    })
    ResponseEntity<Country> saveCountry(@RequestBody Country country);

    @PutMapping(value = APP_ROOT + "/countries/update/{countId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Country par son ID",
            notes = "Cette méthode permet de modifier une Country par son ID", response = Country.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Country a été modifiée"),
            @ApiResponse(code = 400, message = "La Country a n'est pas modifiée")
    })
    ResponseEntity<Country> updateCountry(@PathVariable(value = "countId") Long countId, @RequestBody Country country);

    @GetMapping(value = APP_ROOT + "/countries/findById/{countId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Country par ID",
            notes = "Cette méthode permet de chercher une Country par son ID", response = Category.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La v a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Country n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<Country> getCountryById(@PathVariable(value = "countId") Long countId) throws ResourceNotFoundException;

    @GetMapping(value = APP_ROOT + "/countries/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Country par ordre decroissante ",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Countries par ordre decroissante", responseContainer = "List<Country>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Countries / une liste vide")
    })
    ResponseEntity<List<Country>> getAllCountries();

    @GetMapping(value = APP_ROOT + "/countries/searchAllCountriesOderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Country",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Countries", responseContainer = "List<Country>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Countries / une liste vide")
    })
    ResponseEntity<List<Country>> getAllCountriesOderByIdDesc();

    @DeleteMapping(value = APP_ROOT + "/countries/delete/{countId}")
    @ApiOperation(value = "Supprimer un Country par son ID",
            notes = "Cette méthode permet de supprimer une Country par son ID", response = Country.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Country a été supprimé")
    })
    void deleteCountry(@PathVariable(name = "countId") Long countId);

}
