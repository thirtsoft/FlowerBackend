package com.flowers.controllers.api;

import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.models.HistoriqueLogin;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import static com.flowers.utils.Constants.APP_ROOT;

public interface HistoriqueLoginApi {

    @PostMapping(value = APP_ROOT + "/historiqueLogins/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un HistoriqueLogin",
            notes = "Cette méthode permet d'ajouter un HistoriqueLogin", response = HistoriqueLoginDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le HistoriqueLogin a été crée"),
            @ApiResponse(code = 400, message = "Aucun HistoriqueLogin  crée / modifié")
    })
    ResponseEntity<HistoriqueLoginDto> saveHistoriqueLogin(@RequestBody HistoriqueLoginDto historiqueLoginDto);

    @GetMapping(value = APP_ROOT + "/historiqueLogins/findById/{idHistLog}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une HistoriqueLogin par ID",
            notes = "Cette méthode permet de chercher une HistoriqueLogin par son ID", response = HistoriqueLoginDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La HistoriqueLogin a été trouver"),
            @ApiResponse(code = 404, message = "Aucun HistoriqueLogin n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<HistoriqueLoginDto> getHistoriqueLoginById(@PathVariable("idHistLog") Long id);

    @GetMapping(value = APP_ROOT + "/historiqueLogins/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des HistoriqueLogin",
            notes = "Cette méthode permet de chercher et renvoyer la liste des HistoriqueLogin", responseContainer = "List<HistoriqueLoginDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des HistoriqueLogin / une liste vide")
    })
    ResponseEntity<List<HistoriqueLoginDto>> getAllHistoriqueLogins();

    @GetMapping(value = APP_ROOT + "/historiqueLogins/searchAllHistoriqueLoginsOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des HistoriqueLogin par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des HistoriqueLogin par ordre descroissante",
            responseContainer = "List<HistoriqueLoginDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des HistoriqueLogin  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<HistoriqueLoginDto>> getAllHistoriqueLoginOrderByIdDesc();


    @GetMapping(value = APP_ROOT + "/historiqueLogins/countNumberOfHistoriqueLogin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de HistoriqueLogin",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de HistoriqueLogin")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de HistoriqueLogin / le nombre est nulle")
    })
    BigDecimal countNumberOfHistoriqueLogins();

    @DeleteMapping(value = APP_ROOT + "/historiqueLogins/delete/{idHistLog}")
    @ApiOperation(value = "Supprimer un HistoriqueLogin par son ID",
            notes = "Cette méthode permet de supprimer une HistoriqueLogin par son ID", response = HistoriqueLoginDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La HistoriqueLogin a été supprimé")
    })
    void delete(@PathVariable("idHistLog") Long id);
}
