package com.flowers.controllers.api;

import com.flowers.dtos.CountryDto;
import com.flowers.models.Category;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/countries")
public interface CountryApi {

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un countrie",
            notes = "Cette méthode permet d'ajouter une countrie", response = CountryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Country a été crée"),
            @ApiResponse(code = 400, message = "Aucun Country  crée / modifié")
    })
    ResponseEntity<CountryDto> saveCountry(@RequestBody CountryDto countryDto);

    @PutMapping(value = "/update/{countId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Country par son ID",
            notes = "Cette méthode permet de modifier une Country par son ID", response = CountryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Country a été modifiée"),
            @ApiResponse(code = 400, message = "La Country a n'est pas modifiée")
    })
    ResponseEntity<CountryDto> updateCountry(@PathVariable(value = "countId") Long countId, @RequestBody CountryDto countryDto);

    @GetMapping(value = "/findById/{countId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Country par ID",
            notes = "Cette méthode permet de chercher une Country par son ID", response = Category.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La v a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Country n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<CountryDto> getCountryById(@PathVariable(value = "countId") Long countId);

    @GetMapping(value = "/search-all-active-countries", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des countries actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des countries actives",
            responseContainer = "List<CountryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des countries par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<CountryDto>> getAllActiveCountries();

    @DeleteMapping(value = "/delete-country/{countId}")
    @ApiOperation(value = "Supprimer un countrie par son ID",
            notes = "Cette méthode permet de supprimer un countrie  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le countrie a été supprimé")
    })
    void deleteCountry(@PathVariable("countId") Long countId);

}
