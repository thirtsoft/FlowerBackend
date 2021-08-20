package com.flowers.controllers.api;

import com.flowers.models.Country;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;


public interface CountryApi {

    @PostMapping(value = APP_ROOT + "/countries/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Country> saveCountry(@RequestBody Country Country);

    @PutMapping(value = APP_ROOT + "/countries/update/{catId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Country> updateCountry(@PathVariable(value = "catId") Long catId, @RequestBody Country Country);

    @GetMapping(value = APP_ROOT + "/countries/{catId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Country> findCountryById(@PathVariable(value = "catId") Long catId);

    @GetMapping(value = APP_ROOT + "/countries/searchCountryByCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Country> findByCode(@RequestParam(name = "code") String code);

    @GetMapping(value = APP_ROOT + "/countries/searchCountryByDesignation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Country> findByDesignation(@RequestParam(name = "designation") String designation);

    @GetMapping(value = APP_ROOT + "/countries/all", produces = MediaType.APPLICATION_JSON_VALUE)
   /* @ApiOperation(value = "Renvoi la liste des approvisonnement",
            notes = "Cette méthode permet de chercher et renvoyer la liste des approvisionnements", responseContainer = "List<Approvisionnement>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des approvisionnements / une liste vide")
    })*/
    ResponseEntity<List<Country>> getAllCountries();

    @GetMapping(value = APP_ROOT + "/countries/searchListcountriesByCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Country>> getListCountriesByCode(@RequestParam(name = "code") String code);

    @GetMapping(value = APP_ROOT + "/countries/searchListcountriesByDesignation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Country>> getListCountriesByDesignation(@RequestParam(name = "designation") String designation);

    @DeleteMapping(value = APP_ROOT + "/countries/delete/{catId}")
    void deleteCountry(@PathVariable(name = "catId") Long catId);

}
