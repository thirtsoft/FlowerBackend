package com.flowers.controllers.api;

import com.flowers.dtos.AddressDto;
import com.flowers.exceptions.ResourceNotFoundException;
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
            notes = "Cette méthode permet d'ajouter un addresse", response = AddressDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'Address a été crée"),
            @ApiResponse(code = 400, message = "Aucun Address  crée / modifié")

    })
    ResponseEntity<AddressDto> saveAddress(@RequestBody AddressDto addressDto);

    @PutMapping(value = APP_ROOT + "/addresses/update/{addId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Address",
            notes = "Cette méthode permet de modifier une addresse", response = AddressDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été crée"),
            @ApiResponse(code = 400, message = "Aucun Address  crée / modifié")

    })
    ResponseEntity<AddressDto> updateAddress(@PathVariable(value = "addId") Long addId, @RequestBody AddressDto addressDto);

    @GetMapping(value = APP_ROOT + "/addresses/findById/{addId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher une Address",
            notes = "Cette méthode permet de chercher et de renvoyer une addresse", response = AddressDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été trouvé")

    })
    ResponseEntity<AddressDto> getAddressById(@PathVariable(value = "addId") Long addId);


    @GetMapping(value = APP_ROOT + "/addresses/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des addresses",
            notes = "Cette méthode permet de chercher et renvoyer la liste des addresses", responseContainer = "List<AddressDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Address / une liste vide")
    })
    ResponseEntity<List<AddressDto>> getAllAddresses();

    @GetMapping(value = APP_ROOT + "/addresses/searchAllAddressOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des addresses par ordre decroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des addresses par ordre decroissante", responseContainer = "List<AddressDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Address / une liste vide")
    })
    ResponseEntity<List<AddressDto>> getAllAddressesOrderByIdDesc();


    @DeleteMapping(value = APP_ROOT + "/addresses/delete/{addId}")
    @ApiOperation(value = "Supprimer une addresses",
            notes = "Cette méthode permet de supprimer une addresses")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address est supprimé / une liste vide")
    })
    void delete(@PathVariable(name = "addId") Long addId);

    @GetMapping(value = APP_ROOT + "/addresses/search-all-active-addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Address Livraisons actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Address Livraisons actives",
            responseContainer = "List<AddressDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Address Livraisons par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<AddressDto>> getAllActiveAddresses();

    @DeleteMapping(value = APP_ROOT + "/addresses/delete-addresse/{addId}")
    @ApiOperation(value = "Supprimer une addresse de livraison par son ID",
            notes = "Cette méthode permet de supprimer une addresse de livraison  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été supprimé")
    })
    void deleteAddress(@PathVariable("addId") Long addId);

}
