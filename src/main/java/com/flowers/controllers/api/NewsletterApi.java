package com.flowers.controllers.api;

import com.flowers.dtos.NewsletterDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/newsletters")
public interface NewsletterApi {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Newsletter",
            notes = "Cette méthode permet d'ajouter une Newsletter", response = NewsletterDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Newsletter a été crée"),
            @ApiResponse(code = 400, message = "Aucune Newsletter  crée / modifié")

    })
    ResponseEntity<NewsletterDto> saveNewsletter(@RequestBody NewsletterDto newsletterDto);

    @GetMapping(value = "/count-number-of-newsletter", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Newsletter",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Newsletter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Newsletter / le nombre est nulle")
    })
    BigDecimal countNumberOfNewsletter();

    @GetMapping(value = "/search-all-active-newsletters", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des newsletters actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des newsletters actives",
            responseContainer = "List<NewsletterDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des newsletters par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<NewsletterDto>> getAllActiveNewsletters();

    @DeleteMapping(value = "/delete-newsletter/{idNewsletter}")
    @ApiOperation(value = "Supprimer un newsletter par son ID",
            notes = "Cette méthode permet de supprimer un newsletter  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le newsletter a été supprimé")
    })
    void deleteNewsletter(@PathVariable("idNewsletter") Long idNewsletter);
}
