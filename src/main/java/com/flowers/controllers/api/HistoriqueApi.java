package com.flowers.controllers.api;

import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.dtos.HistoriqueLoginDto;
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

@RequestMapping(value = APP_ROOT + "/historiques")
public interface HistoriqueApi {

    @GetMapping(value = "/count-number-of-historique-commandes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de HistoriqueCommandeDto",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de HistoriqueCommandeDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de HistoriqueCommandeDto / le nombre est nulle")
    })
    BigDecimal countNumberOfHistoriqueCommandeDtos();

    @GetMapping(value = "/search-all-active-historique-commandes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des historiqueCommandes actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des historiqueCommandes actives",
            responseContainer = "List<HistoriqueCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des historiqueCommandes par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<HistoriqueCommandeDto>> getAllActiveHistoriqueCommandes();

    @DeleteMapping(value = "/delete-historique-commande/{idHistCom}")
    @ApiOperation(value = "Supprimer un historiqueCommande par son ID",
            notes = "Cette méthode permet de supprimer un historiqueCommande  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le historiqueCommande a été supprimé")
    })
    void deleteHistoriqueCommande(@PathVariable("idHistCom") Long idHistCom);

    @GetMapping(value = "/count-number-of-historique-login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de HistoriqueLogin",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de HistoriqueLogin")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de HistoriqueLogin / le nombre est nulle")
    })
    BigDecimal countNumberOfHistoriqueLogins();

    @GetMapping(value = "/search-all-active-historique-logins", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des historiqueLogins actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des historiqueLogins actives",
            responseContainer = "List<HistoriqueLoginDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des historiqueLogins par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<HistoriqueLoginDto>> getAllActiveHistoriqueLogins();

    @DeleteMapping(value = "/delete-historique-login/{idHistLog}")
    @ApiOperation(value = "Supprimer un historiqueLogin par son ID",
            notes = "Cette méthode permet de supprimer un historiqueLogin  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le historiqueLogin a été supprimé")
    })
    void deleteHistoriqueLogin(@PathVariable("idHistLog") Long idHistLog);
}
