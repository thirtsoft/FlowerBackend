package com.flowers.controllers.api;

import com.flowers.models.Address;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;


public interface AddressApi {

    @PostMapping(value = APP_ROOT + "/addresses/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Address",
            notes = "Cette méthode permet d'ajouter un article", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'Address a été crée"),
            @ApiResponse(code = 400, message = "Aucun Address  crée / modifié")

    })
    ResponseEntity<Address> saveAddress(@RequestBody Address address);

    @PutMapping(value = APP_ROOT + "/addresses/update/{catId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Address> updateAddress(@PathVariable(value = "catId") Long catId, @RequestBody Address address);

    @GetMapping(value = APP_ROOT + "/addresses/{catId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Address> findAddressById(@PathVariable(value = "catId") Long catId);

    @GetMapping(value = APP_ROOT + "/addresses/searchAddressByCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Address> findByCode(@RequestParam(name = "code") String code);

    @GetMapping(value = APP_ROOT + "/addresses/searchAddressByDesignation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Address> findByDesignation(@RequestParam(name = "designation") String designation);

    @GetMapping(value = APP_ROOT + "/addresses/all", produces = MediaType.APPLICATION_JSON_VALUE)
   /* @ApiOperation(value = "Renvoi la liste des approvisonnement",
            notes = "Cette méthode permet de chercher et renvoyer la liste des approvisionnements", responseContainer = "List<Approvisionnement>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des approvisionnements / une liste vide")
    })*/
    ResponseEntity<List<Address>> getAlladdresses();

    @GetMapping(value = APP_ROOT + "/addresses/searchListaddressesByCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Address>> getListaddressesByCode(@RequestParam(name = "code") String code);

    @GetMapping(value = APP_ROOT + "/addresses/searchListaddressesByDesignation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Address>> getListaddressesByDesignation(@RequestParam(name = "designation") String designation);

    @DeleteMapping(value = APP_ROOT + "/addresses/delete/{catId}")
    void deleteAddress(@PathVariable(name = "catId") Long catId);

}
