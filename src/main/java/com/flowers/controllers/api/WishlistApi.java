package com.flowers.controllers.api;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Wishlist;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface WishlistApi {

    @PostMapping(value = APP_ROOT + "/wishlists/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Wishlist",
            notes = "Cette méthode permet d'ajouter un Wishlist", response = Wishlist.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le Wishlist a été crée"),
            @ApiResponse(code = 400, message = "Aucun Wishlist  crée / modifié")

    })
    ResponseEntity<Wishlist> saveWishlist(@RequestBody Wishlist wishlist);

    @PutMapping(value = APP_ROOT + "/wishlists/update/{wishlistId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Wishlist",
            notes = "Cette méthode permet de modifier une Wishlist", response = Wishlist.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Wishlist a été crée"),
            @ApiResponse(code = 400, message = "Aucun Wishlist  crée / modifié")

    })
    ResponseEntity<Wishlist> updateWishlist(@PathVariable(value = "wishlistId") Long wishlistId, @RequestBody Wishlist wishlist);

    @GetMapping(value = APP_ROOT + "/wishlists/findById/{wishlistId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher une Wishlist",
            notes = "Cette méthode permet de chercher et de renvoyer une Wishlist", response = Wishlist.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Wishlist a été trouvé")

    })
    ResponseEntity<Wishlist> getWishlistById(@PathVariable(value = "wishlistId") Long wishlistId) throws ResourceNotFoundException;

    @GetMapping(value = APP_ROOT + "/wishlists/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Wishlist",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Wishlist", responseContainer = "List<Wishlist>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Wishlist / une liste vide")
    })
    ResponseEntity<List<Wishlist>> getAllWishlists();

    @GetMapping(value = APP_ROOT + "/wishlists/searchAllWishlistsOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Wishlist par ordre decroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Wishlist par ordre decroissante", responseContainer = "List<Wishlist>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Wishlist / une liste vide")
    })
    ResponseEntity<List<Wishlist>> getAllWishlistsOrderByIdDesc();

    @DeleteMapping(value = APP_ROOT + "/wishlists/delete/{wishlistId}")
    @ApiOperation(value = "Supprimer un Wishlist par son ID",
            notes = "Cette méthode permet de supprimer une Country par son ID", response = Wishlist.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Wishlist a été supprimé")
    })
    void deleteWishlist(@PathVariable(name = "wishlistId") Long wishlistId);
}
