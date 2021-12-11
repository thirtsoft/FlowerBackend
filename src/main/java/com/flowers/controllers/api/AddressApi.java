package com.flowers.controllers.api;

import com.flowers.exceptions.ResourceNotFoundException;
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
            notes = "Cette méthode permet d'ajouter un addresse", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'Address a été crée"),
            @ApiResponse(code = 400, message = "Aucun Address  crée / modifié")

    })
    ResponseEntity<Address> saveAddress(@RequestBody Address address);

    @PutMapping(value = APP_ROOT + "/addresses/update/{addId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Address",
            notes = "Cette méthode permet de modifier une addresse", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été crée"),
            @ApiResponse(code = 400, message = "Aucun Address  crée / modifié")

    })
    ResponseEntity<Address> updateAddress(@PathVariable(value = "addId") Long addId, @RequestBody Address address);

    @GetMapping(value = APP_ROOT + "/addresses/findById/{addId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher une Address",
            notes = "Cette méthode permet de chercher et de renvoyer une addresse", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été trouvé")

    })
    ResponseEntity<Address> getAddressById(@PathVariable(value = "addId") Long addId) throws ResourceNotFoundException;


    @GetMapping(value = APP_ROOT + "/addresses/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des addresses",
            notes = "Cette méthode permet de chercher et renvoyer la liste des addresses", responseContainer = "List<Address>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Address / une liste vide")
    })
    ResponseEntity<List<Address>> getAllAddresses();

    @GetMapping(value = APP_ROOT + "/addresses/searchAllAddressOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des addresses par ordre decroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des addresses par ordre decroissante", responseContainer = "List<Address>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Address / une liste vide")
    })
    ResponseEntity<List<Address>> getAllAddressesOrderByIdDesc();


    @DeleteMapping(value = APP_ROOT + "/addresses/delete/{addId}")
    @ApiOperation(value = "Supprimer une addresses",
            notes = "Cette méthode permet de supprimer une addresses")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address est supprimé / une liste vide")
    })
    ResponseEntity<?> deleteAddress(@PathVariable(name = "addId") Long addId);

}
