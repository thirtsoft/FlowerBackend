package com.flowers.controllers.api;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Fournisseur;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface FournisseurApi {

    @PostMapping(value = APP_ROOT + "/fournisseurs/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Fournisseur",
            notes = "Cette méthode permet d'ajouter un Fournisseur", response = Fournisseur.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le Fournisseur a été crée"),
            @ApiResponse(code = 400, message = "Aucun Fournisseur  crée / modifié")

    })
    ResponseEntity<Fournisseur> save(@RequestBody Fournisseur fournisseur);

    @PutMapping(value = APP_ROOT + "/fournisseurs/update/{idFournisseur}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier un Fournisseur",
            notes = "Cette méthode permet de modifier un Fournisseur", response = Fournisseur.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Fournisseur a été crée"),
            @ApiResponse(code = 400, message = "Aucun Fournisseur  crée / modifié")

    })
    ResponseEntity<Fournisseur> update(@PathVariable("idFournisseur") Long id, @RequestBody Fournisseur fournisseur);

    @GetMapping(value = APP_ROOT + "/fournisseurs/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher un Fournisseur",
            notes = "Cette méthode permet de chercher et de renvoyer un Fournisseur", response = Fournisseur.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été trouvé")

    })
    ResponseEntity<Fournisseur> getFournisseurById(@PathVariable("idFournisseur") Long id) throws ResourceNotFoundException;

    @GetMapping(value = APP_ROOT + "/fournisseurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Fournisseurs",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Fournisseurs", responseContainer = "List<Fournisseur>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Countries / une liste vide")
    })
    ResponseEntity<List<Fournisseur>> getAllFournisseurs();

    @GetMapping(value = APP_ROOT + "/fournisseurs/searchAllFournisseurOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Fournisseurs par ordre decroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Fournisseurs par ordre decroissante", responseContainer = "List<Fournisseur>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Countries / une liste vide")
    })
    ResponseEntity<List<Fournisseur>> getAllFournisseursOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/fournisseurs/countNumberOfFournisseur", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Fournisseur",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Fournisseur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Fournisseur / le nombre est nulle")
    })
    BigDecimal countNumberOfFournisseur();

    @DeleteMapping(value = APP_ROOT + "/fournisseurs/delete/{idFournisseur}")
    @ApiOperation(value = "Supprimer un Fournisseur par son ID",
            notes = "Cette méthode permet de supprimer une Fournisseur par son ID", response = Fournisseur.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Country a été supprimé")
    })
    void delete(@PathVariable("idFournisseur") Long id);
}
