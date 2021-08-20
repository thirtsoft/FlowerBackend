package com.flowers.controllers.api;

import com.flowers.models.State;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;


public interface StateApi {

    @PostMapping(value = APP_ROOT + "/states/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<State> saveState(@RequestBody State State);

    @PutMapping(value = APP_ROOT + "/states/update/{catId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<State> updateState(@PathVariable(value = "catId") Long catId, @RequestBody State State);

    @GetMapping(value = APP_ROOT + "/states/{catId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<State> findStateById(@PathVariable(value = "catId") Long catId);

    @GetMapping(value = APP_ROOT + "/states/searchStateByCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<State> findByCode(@RequestParam(name = "code") String code);

    @GetMapping(value = APP_ROOT + "/states/searchStateByDesignation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<State> findByDesignation(@RequestParam(name = "designation") String designation);

    @GetMapping(value = APP_ROOT + "/states/all", produces = MediaType.APPLICATION_JSON_VALUE)
   /* @ApiOperation(value = "Renvoi la liste des approvisonnement",
            notes = "Cette méthode permet de chercher et renvoyer la liste des approvisionnements", responseContainer = "List<Approvisionnement>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des approvisionnements / une liste vide")
    })*/
    ResponseEntity<List<State>> getAllStates();

    @GetMapping(value = APP_ROOT + "/states/searchListstatesByCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<State>> getListStatesByCode(@RequestParam(name = "code") String code);

    @GetMapping(value = APP_ROOT + "/states/searchListstatesByDesignation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<State>> getListstatesByDesignation(@RequestParam(name = "designation") String designation);

    @DeleteMapping(value = APP_ROOT + "/states/delete/{catId}")
    void deleteState(@PathVariable(name = "catId") Long catId);

}
