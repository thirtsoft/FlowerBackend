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

@RequestMapping(value = APP_ROOT + "/addresses")
public interface AddressApi {

    @GetMapping(value = "/findById/{addId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher une Address",
            notes = "Cette méthode permet de chercher et de renvoyer une addresse", response = AddressDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été trouvé")

    })
    ResponseEntity<AddressDto> getAddressById(@PathVariable(value = "addId") Long addId);

    @GetMapping(value = "/search-all-active-addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Address Livraisons actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Address Livraisons actives",
            responseContainer = "List<AddressDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Address Livraisons par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<AddressDto>> getAllActiveAddresses();

    @DeleteMapping(value = "/delete-address/{addId}")
    @ApiOperation(value = "Supprimer une addresse de livraison par son ID",
            notes = "Cette méthode permet de supprimer une addresse de livraison  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été supprimé")
    })
    void deleteAddress(@PathVariable("addId") Long addId);

}
