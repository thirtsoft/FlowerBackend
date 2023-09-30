package com.flowers.controllers.api;

import com.flowers.dtos.LigneCommandeDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/orderItems")
public interface LigneCommandeApi {

    @GetMapping(value = "/findById/{idOrderItem}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher une ligne de commande",
            notes = "Cette méthode permet de chercher et de renvoyer une ligne de commande", response = LigneCommandeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été trouvé")

    })
    ResponseEntity<LigneCommandeDto> getOrderItemById(@PathVariable("idOrderItem") Long id);

    @GetMapping(value =  "/find-all-orderItems-group-by-IdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des orderItems par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des orderItems par ordre descroissante",
            responseContainer = "List<LigneCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Articles  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<LigneCommandeDto>> getAllOrderItemsGroupByProductIdDesc();

    @GetMapping(value = "/search-all-orderItems-by-orderId/{comId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des orderItems  par commande ID",
            notes = "Cette méthode permet de chercher et renvoyer la liste des orderItems par  commande ID",
            responseContainer = "List<OrderItem>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des orderItems  par commande ID / une liste vide")
    })
    ResponseEntity<List<LigneCommandeDto>> getAllOrderItemsByOrderId(@PathVariable("comId") Long comId);

    @GetMapping(value = "/search-top200-orderItems-order-by-IdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 200 dernières orderItems  par ordre décroissant",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 200 derniers orderItems par ID décroissant",
            responseContainer = "List<LigneCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des 200 dernières orderItems  par ID décroissant / une liste vide")
    })
    ResponseEntity<List<LigneCommandeDto>> getTop200OrderItemsOrderByIdDesc();

    @GetMapping(value = "/search-top8-orderItems-order-by-IdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 8 produits les plus vendus par ordre décroissant",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 8 produits les plus vendus par ID décroissant",
            responseContainer = "List<LigneCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des 8 produits les plus vendusorderItems  par ID décroissant / une liste vide")
    })
    ResponseEntity<List<LigneCommandeDto>> getTop8OrderItemsOrderByIdDesc();

    @GetMapping(value = "/search-top3-orderItems-order-by-IdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 3 produits les plus vendus par ordre décroissant",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 3 produits les plus vendus par ID décroissant",
            responseContainer = "List<LigneCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des 3 produits les plus vendusorderItems  par ID décroissant / une liste vide")
    })
    ResponseEntity<List<LigneCommandeDto>> getTop3OrderItemsOrderByIdDesc();

    @GetMapping(value = "/search-all-active-orderItems", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des orderItems actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des orderItems actives",
            responseContainer = "List<LigneCommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des orderItems par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<LigneCommandeDto>> getAllActiveLigneCommandes();
}
