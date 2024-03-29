package com.flowers.controllers.api;

import com.flowers.dtos.ProductDto;
import com.flowers.dtos.RatingDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Rating;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import static com.flowers.utils.Constants.APP_ROOT;

public interface RatingApi {

    @PostMapping(value = APP_ROOT + "/ratings/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Rating",
            notes = "Cette méthode permet d'ajouter une Rating", response = RatingDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Rating a été crée"),
            @ApiResponse(code = 400, message = "Aucune Rating  crée / modifié")

    })
    ResponseEntity<RatingDto> saveRating(@RequestBody RatingDto ratingDto);

    @PostMapping(value = APP_ROOT + "/ratings/createRatingToArticle",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Rating pour un article donnée",
            notes = "Cette méthode permet d'ajouter une Rating pour un article donnée",
            response = RatingDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Rating a été crée"),
            @ApiResponse(code = 400, message = "Aucune Rating  crée / modifié")

    })
    ResponseEntity<RatingDto> saveRatingToArticle(@RequestParam("id") Long id, @RequestBody RatingDto ratingDto);


    @PostMapping(value = APP_ROOT + "/ratings/createRatingToArticleWithUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Rating pour un article",
            notes = "Cette méthode permet d'attribuer une note à un article", response = RatingDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Rating a été crée"),
            @ApiResponse(code = 400, message = "Aucune Rating  crée / modifié")

    })
    ResponseEntity<RatingDto> saveRating(@RequestBody RatingDto ratingDto, @RequestParam("reference") String reference, @RequestParam Long id);

    @GetMapping(value = APP_ROOT + "/ratings/findById/{idRating}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Rating par ID",
            notes = "Cette méthode permet de chercher une Rating par son ID", response = RatingDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Rating a été trouver"),
            @ApiResponse(code = 404, message = "Aucune Rating n'existe avec cette ID pas dans la BD")

    })
    ResponseEntity<RatingDto> getRatingById(@PathVariable("idRating") Long id);

    @GetMapping(value = APP_ROOT + "/ratings/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Rating",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Rating", responseContainer = "List<RatingDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Rating / une liste vide")
    })
    ResponseEntity<List<RatingDto>> getAllRatings();

    @GetMapping(value = APP_ROOT + "/ratings/searchAllRatingsOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Notations par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Notations par ordre descroissante",
            responseContainer = "List<RatingDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Notations  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<RatingDto>> getAllRatingsOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/ratings/countNumberOfRating", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Rating",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Rating")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Rating / le nombre est nulle")
    })
    BigDecimal countNumberOfRating();


    @GetMapping(value = APP_ROOT + "/ratings/countNumberOfRatingByProductId/{idProd}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Rating d'un produit",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Rating pour un produit donné")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Rating du produit / le nombre est nulle")
    })
    BigDecimal countNumberOfRatingByProductId(@PathVariable("idProd") String prodRef);

    @GetMapping(value = APP_ROOT + "/ratings/searchTop4RatingOrderByCreatedDateDescByProductId/{idProd}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 4 dernières Rating d'un produit",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 4 dernières Rating d'un produit", responseContainer = "List<RatingDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des 4 dernières Rating d'un produit / une liste vide")
    })
    ResponseEntity<List<RatingDto>> getTop4ByOrderByCreatedDateDescByProductId(@PathVariable("idProd") String prodRef);

    @DeleteMapping(value = APP_ROOT + "/ratings/delete/{idRating}")
    @ApiOperation(value = "Supprimer une Rating par son ID",
            notes = "Cette méthode permet de supprimer une Rating par son ID", response = Rating.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Rating a été supprimé")
    })
    void delete(@PathVariable("idRating") Long id);

    @GetMapping(value = APP_ROOT + "/ratings/search-all-active-ratings", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des ratings actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des ratings actives",
            responseContainer = "List<RatingDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des ratings par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<RatingDto>> getAllActiveRatings();

    @DeleteMapping(value = APP_ROOT + "/ratings/delete-rating/{idRating}")
    @ApiOperation(value = "Supprimer un ratings par son ID",
            notes = "Cette méthode permet de supprimer un ratings  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le ratings a été supprimé")
    })
    void deleteRating(@PathVariable("idRating") Long idRating);
}
