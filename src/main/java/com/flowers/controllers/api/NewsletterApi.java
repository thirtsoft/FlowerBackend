package com.flowers.controllers.api;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Newsletter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface NewsletterApi {

    @PostMapping(value = APP_ROOT + "/newsletters/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Newsletter",
            notes = "Cette méthode permet d'ajouter une Newsletter", response = Newsletter.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Newsletter a été crée"),
            @ApiResponse(code = 400, message = "Aucune Newsletter  crée / modifié")

    })
    ResponseEntity<Newsletter> save(@RequestBody Newsletter newsletter);

    @GetMapping(value = APP_ROOT + "/newsletters/findById/{idNewsletter}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Newsletter par ID",
            notes = "Cette méthode permet de chercher une Newsletter par son ID", response = Newsletter.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Newsletter a été trouver"),
            @ApiResponse(code = 404, message = "Aucune Newsletter n'existe avec cette ID pas dans la BD")

    })
    ResponseEntity<Newsletter> getNewsletterById(@PathVariable("idNewsletter") Long id) throws ResourceNotFoundException;

    @GetMapping(value = APP_ROOT + "/newsletters/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Newsletter",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Newsletter", responseContainer = "List<Newsletter>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Newsletter / une liste vide")
    })
    ResponseEntity<List<Newsletter>> findAll();

    @GetMapping(value = APP_ROOT + "/newsletters/searchAllNewslettersOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Newsletter par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Newsletter par ordre descroissante",
            responseContainer = "List<Newsletter>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Newsletter  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<Newsletter>> getAllNewslettersOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/newsletters/countNumberOfNewsletter", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Newsletter",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Newsletter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Newsletter / le nombre est nulle")
    })
    BigDecimal countNumberOfNewsletter();

    @DeleteMapping(value = APP_ROOT + "/newsletters/delete/{idNewsletter}")
    @ApiOperation(value = "Supprimer une Newsletter par son ID",
            notes = "Cette méthode permet de supprimer une Newsletter par son ID", response = Newsletter.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Newsletter a été supprimé")
    })
    void delete(@PathVariable("idNewsletter") Long id);
}