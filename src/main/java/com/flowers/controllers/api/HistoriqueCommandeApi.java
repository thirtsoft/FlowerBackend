package com.flowers.controllers.api;

import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.HistoriqueCommandeDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface HistoriqueCommandeApi {

    @PostMapping(value = APP_ROOT + "/historiqueCommandes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un HistoriqueCommandeDto",
            notes = "Cette méthode permet d'ajouter un HistoriqueCommandeDto", response = HistoriqueCommandeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le HistoriqueCommandeDto a été crée"),
            @ApiResponse(code = 400, message = "Aucun HistoriqueCommandeDto  crée / modifié")
    })
    ResponseEntity<HistoriqueCommandeDto> save(@RequestBody HistoriqueCommandeDto historiqueCommandeDto);

    @GetMapping(value = APP_ROOT + "/historiqueCommandes/findById/{idHistCom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une HistoriqueCommandeDto par ID",
            notes = "Cette méthode permet de chercher une HistoriqueCommandeDto par son ID", response = HistoriqueCommandeDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La HistoriqueCommandeDto a été trouver"),
            @ApiResponse(code = 404, message = "Aucun HistoriqueCommandeDto n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<HistoriqueCommandeDto> getHistoriqueCommqndeById(@PathVariable("idHistCom") Long id);

    @GetMapping(value = APP_ROOT + "/historiqueCommandes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des HistoriqueCommandeDto",
            notes = "Cette méthode permet de chercher et renvoyer la liste des HistoriqueCommandeDto", responseContainer = "List<HistoriqueCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des HistoriqueCommandeDto / une liste vide")
    })
    ResponseEntity<List<HistoriqueCommandeDto>> getAllHistoriqueCommqndes();

    @GetMapping(value = APP_ROOT + "/historiqueCommandes/searchAllHistoriqueCommandesOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des HistoriqueCommandeDto par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des HistoriqueCommandeDto par ordre descroissante",
            responseContainer = "List<HistoriqueCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des HistoriqueCommandeDto  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<HistoriqueCommandeDto> > getAllHistoriqueCommandesOrderByIdDesc();


    @GetMapping(value = APP_ROOT + "/historiqueCommandes/countNumberOfHistoriqueCommandes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de HistoriqueCommandeDto",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de HistoriqueCommandeDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de HistoriqueCommandeDto / le nombre est nulle")
    })
    BigDecimal countNumberOfHistoriqueCommandeDtos();

    @DeleteMapping(value = APP_ROOT + "/historiqueCommandes/delete/{idHistCom}")
    @ApiOperation(value = "Supprimer un HistoriqueCommandeDto par son ID",
            notes = "Cette méthode permet de supprimer une HistoriqueCommandeDto par son ID", response = HistoriqueCommandeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La HistoriqueCommande a été supprimé")
    })
    void delete(@PathVariable("idHistCom") Long id);

    @GetMapping(value = APP_ROOT + "/historiqueCommandes/search-all-active-historiqueCommandes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des historiqueCommandes actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des historiqueCommandes actives",
            responseContainer = "List<HistoriqueCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des historiqueCommandes par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<HistoriqueCommandeDto>> getAllActiveHistoriqueCommandes();

    @DeleteMapping(value = APP_ROOT + "/historiqueCommandes/delete-historiqueCommande/{idHistCom}")
    @ApiOperation(value = "Supprimer un historiqueCommande par son ID",
            notes = "Cette méthode permet de supprimer un historiqueCommande  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le historiqueCommande a été supprimé")
    })
    void deleteHistoriqueCommande(@PathVariable("idHistCom") Long idHistCom);

}
