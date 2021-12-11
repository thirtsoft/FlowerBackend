package com.flowers.controllers.api;

import com.flowers.models.Fournisseur;
import com.flowers.models.OrderItem;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface OrderItemApi {

    @PostMapping(value = APP_ROOT + "/orderItems/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une Ligne de commande",
            notes = "Cette méthode permet d'ajouter une Ligne de commande", response = OrderItem.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Ligne de commande a été crée"),
            @ApiResponse(code = 400, message = "Aucun Ligne de commande  crée / modifié")

    })
    ResponseEntity<OrderItem> save(@RequestBody OrderItem orderItem);

    @PutMapping(value = APP_ROOT + "/orderItems/update/{idOrderItem}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une Ligne de commande",
            notes = "Cette méthode permet de modifier une Ligne de commande", response = OrderItem.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Ligne de commande a été crée"),
            @ApiResponse(code = 400, message = "Aucun Ligne de commande  crée / modifié")

    })
    ResponseEntity<OrderItem> update(@PathVariable("idOrderItem") Long id, @RequestBody OrderItem orderItem);

    @GetMapping(value = APP_ROOT + "/orderItems/findById/{idOrderItem}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher une ligne de commande",
            notes = "Cette méthode permet de chercher et de renvoyer une ligne de commande", response = OrderItem.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Address a été trouvé")

    })
    ResponseEntity<OrderItem> getOrderItemById(@PathVariable("idOrderItem") Long id);

    @GetMapping(value = APP_ROOT + "/orderItems/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des ligne de commande",
            notes = "Cette méthode permet de chercher et renvoyer la liste des ligne de commande", responseContainer = "List<OrderItem>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Countries / une liste vide")
    })
    ResponseEntity<List<OrderItem>> getAllOrderItems();

    @GetMapping(value = APP_ROOT + "/orderItems/searchAllOrderItemOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des orderItems par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des orderItems par ordre descroissante",
            responseContainer = "List<OrderItem>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des orderItems  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<OrderItem>> getAllOrderItemOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/orderItems/findAllOrderItemsGroupByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des orderItems par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des orderItems par ordre descroissante",
            responseContainer = "List<OrderItem>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Articles  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<OrderItem>> getAllOrderItemsGroupByProductIdDesc();

    @GetMapping(value = APP_ROOT + "/orderItems/searchAllorderItemsByOrderId/{comId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des orderItems  par commande ID",
            notes = "Cette méthode permet de chercher et renvoyer la liste des orderItems par  commande ID",
            responseContainer = "List<OrderItem>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des orderItems  par commande ID / une liste vide")
    })
    ResponseEntity<List<OrderItem>> getAllOrderItemsByOrderId(@PathVariable("comId") Long comId);

    @GetMapping(value = APP_ROOT + "/orderItems/searchTop200OrderItemsOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des 200 dernières orderItems  par ordre décroissant",
            notes = "Cette méthode permet de chercher et renvoyer la liste des 200 derniers orderItems par ID décroissant",
            responseContainer = "List<OrderItem>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des 200 dernières orderItems  par ID décroissant / une liste vide")
    })
    ResponseEntity<List<OrderItem>> getTop200OrderItemsOrderByIdDesc();

    @DeleteMapping(value = APP_ROOT + "/orderItems/delete/{idOrderItem}")
    @ApiOperation(value = "Supprimer un Ligne de Commande par son ID",
            notes = "Cette méthode permet de supprimer une Ligne de Commande par son ID", response = OrderItem.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La LigneCommande a été supprimé")
    })
    void delete(@PathVariable("idOrderItem") Long id);

}
