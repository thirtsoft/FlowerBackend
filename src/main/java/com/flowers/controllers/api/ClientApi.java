package com.flowers.controllers.api;

import com.flowers.dtos.ClientDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/clients")
public interface ClientApi {

    @GetMapping(value = "/findById/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un Client par ID",
            notes = "Cette méthode permet de chercher un Client par son ID", response = ClientDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Client a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Client n'existe avec cette ID pas dans la BD")

    })
    ResponseEntity<ClientDto> getClientById(@PathVariable("idClient") Long id);

    @GetMapping(value = "/count-number-of-client", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Client",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Client / le nombre est nulle")
    })
    BigDecimal countNumberOfClients();

    @GetMapping(value = "/search-all-active-clients", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des clients actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des clients actives",
            responseContainer = "List<ClientDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des clients par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<ClientDto>> getAllActiveClients();

    @DeleteMapping(value = "/delete-client/{idClient}")
    @ApiOperation(value = "Supprimer un client par son ID",
            notes = "Cette méthode permet de supprimer un client  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client a été supprimé")
    })
    void deleteClient(@PathVariable("idClient") Long idClient);
}