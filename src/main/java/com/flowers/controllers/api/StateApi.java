package com.flowers.controllers.api;

import com.flowers.dtos.RatingDto;
import com.flowers.dtos.StateDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.State;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;


public interface StateApi {

    @PostMapping(value = APP_ROOT + "/states/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une State",
            notes = "Cette méthode permet d'ajouter un State", response = StateDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le State a été crée"),
            @ApiResponse(code = 400, message = "Aucun State  crée / modifié")

    })
    ResponseEntity<StateDto> saveState(@RequestBody StateDto stateDto);

    @PutMapping(value = APP_ROOT + "/states/update/{stateId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une State",
            notes = "Cette méthode permet de modifier une State", response = StateDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le State a été crée"),
            @ApiResponse(code = 400, message = "Aucun State  crée / modifié")

    })
    ResponseEntity<StateDto> updateState(@PathVariable(value = "stateId") Long stateId, @RequestBody StateDto stateDto);

    @GetMapping(value = APP_ROOT + "/states/findById/{stateId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher une State",
            notes = "Cette méthode permet de chercher et de renvoyer une State", response = StateDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le State a été trouvé")

    })
    ResponseEntity<StateDto> getStateById(@PathVariable(value = "stateId") Long stateId);

    @GetMapping(value = APP_ROOT + "/states/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des State",
            notes = "Cette méthode permet de chercher et renvoyer la liste des State", responseContainer = "List<StateDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des State / une liste vide")
    })
    ResponseEntity<List<StateDto>> getAllStates();

    @GetMapping(value = APP_ROOT + "/states/searchAllStatesOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des State par ordre decroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des State par ordre decroissante", responseContainer = "List<StateDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des State / une liste vide")
    })
    ResponseEntity<List<StateDto>> getAllStatesOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/states/searchStateByCountryCode", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des states",
            notes = "Cette méthode permet de chercher et renvoyer la liste des states", responseContainer = "List<StateDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des states / une liste vide")
    })
    ResponseEntity<List<StateDto>> getAllStateByCountryCode(@RequestParam(name = "code") String code);

    @DeleteMapping(value = APP_ROOT + "/states/delete/{stateId}")
    @ApiOperation(value = "Supprimer un State par son ID",
            notes = "Cette méthode permet de supprimer une Country par son ID", response = StateDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le State a été supprimé")
    })
    void delete(@PathVariable(name = "stateId") Long stateId);

    @GetMapping(value = APP_ROOT + "/states/search-all-active-states", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des states actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des states actives",
            responseContainer = "List<StateDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des states par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<StateDto>> getAllActiveStates();

    @DeleteMapping(value = APP_ROOT + "/states/delete-state/{stateId}")
    @ApiOperation(value = "Supprimer un states par son ID",
            notes = "Cette méthode permet de supprimer un states  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le states a été supprimé")
    })
    void deleteState(@PathVariable("stateId") Long stateId);

}
