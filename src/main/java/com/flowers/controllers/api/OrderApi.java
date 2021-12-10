package com.flowers.controllers.api;

import com.flowers.models.Order;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface OrderApi {

    @PostMapping(value = APP_ROOT + "/orders/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une commande",
            notes = "Cette méthode permet d'ajouter une commande", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Country a été crée"),
            @ApiResponse(code = 400, message = "Aucun Country  crée / modifié")
    })
    ResponseEntity<Order> save(@RequestBody Order order);

    @PutMapping(value = APP_ROOT + "/orders/update/{idOrder}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une commande par son ID",
            notes = "Cette méthode permet de modifier une commande par son ID", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Country a été modifiée"),
            @ApiResponse(code = 400, message = "La Country a n'est pas modifiée")
    })
    ResponseEntity<Order> update(@PathVariable("idOrder") Long id, @RequestBody Order order);

    @PatchMapping(value = APP_ROOT + "/orders/updateStatusOfOrder/{id}")
    @ApiOperation(value = "Modifier une Commande par son Status",
            notes = "Cette méthode permet de modifier une Commande par son Status", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le status de la Commande a été modifié")
    })
    ResponseEntity<Order> updateStatusOfOrder(@RequestParam("status") String status, @PathVariable("id") String id);


    @GetMapping(value = APP_ROOT + "/orders/findById/{idOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une commande par ID",
            notes = "Cette méthode permet de chercher une commande par son ID", response = Order.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Country n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<Order> getById(@PathVariable("idOrder") Long id);

    @GetMapping(value = APP_ROOT + "/orders/countNumberOfOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Compter le nombre de commande",
            notes = "Cette méthode permet de Compter le nombre de commande", response = Order.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La v a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Order n'existe avec cette ID pas dans la BD")
    })
    BigDecimal countNumberOfOrder();

    @GetMapping(value = APP_ROOT + "/orders/countNumberOfOrdersInMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Commande du mois",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Commande du mois")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Commande / le nombre est nulle")
    })
    BigDecimal countNumberOfOrdersInMonth();

    @GetMapping(value = APP_ROOT + "/orders/sumTotalOfOrderByMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    BigDecimal sumTotaleOfOrderByMonth();

    @GetMapping(value = APP_ROOT + "/orders/sumTotalOfOrderByYear", produces = MediaType.APPLICATION_JSON_VALUE)
    BigDecimal sumTotaleOfOrderByYear();

    @GetMapping(value = APP_ROOT + "/orders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes", responseContainer = "List<Order>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes / une liste vide")
    })
    ResponseEntity<List<Order>> getAll();

    @GetMapping(value = APP_ROOT + "/orders/searchAllOrdersOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Articles par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Articles par ordre descroissante",
            responseContainer = "List<Order>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Articles  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<Order>> getAllOrdersOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/orders/findListOrderByStatuePending", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes dont le status encours",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes dont le status est encours", responseContainer = "List<Order>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes / une liste vide")
    })
    ResponseEntity<List<Order>> getListOrderByStatusPending();

    @GetMapping(value = APP_ROOT + "/orders/findListOrderByStatuePayed", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes payees",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes payees", responseContainer = "List<Order>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes payees / une liste vide")
    })
    ResponseEntity<List<Order>> getListOrderByStatusPayed();

    @GetMapping(value = APP_ROOT + "/orders/searchOrderByUserIdOrderByIdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<Order>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<Order>> getOrdersByUserOrderByIdDesc(@PathVariable(name = "id") Long id);

    @GetMapping(value = APP_ROOT + "/orders/searchOrderByBillingAddressIdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<Order>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<Order>> getOrdersByBillingAddressOrderByIdDesc(@PathVariable(name = "id") Long id);

    @GetMapping(value = APP_ROOT + "/orders/searchOrderByShippingAddressIdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<Order>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<Order>> getOrdersByShippingAddressByIdDesc(@PathVariable(name = "id") Long id);


    @GetMapping(value = APP_ROOT + "/orders/numberOfOrderByMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    List<?> countNumberOfOrderByMonth();

    @GetMapping(value = APP_ROOT + "/orders/sumTotaleOfOrderByMonthByList", produces = MediaType.APPLICATION_JSON_VALUE)
    List<?> getSumTotaleOfOrderByMonth();

    @GetMapping(value = APP_ROOT + "/orders/searchOrdersByUtilisateurIdByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commande par client",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commande par Client par pages", responseContainer = "Page<Order>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commande par Client par pages / une liste vide")
    })
    Page<Order> getOrdersByUtilisateurIdByPageables(@RequestParam("userId") Long userId, @RequestParam(name = "page") int page,
                                                    @RequestParam(name = "size") int size);

    @DeleteMapping(value = APP_ROOT + "/orders/delete/{idOrder}")
    @ApiOperation(value = "Supprimer une Commande par son ID",
            notes = "Cette méthode permet de supprimer une Commande par son ID", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La CommandeDto a été supprimé")
    })
    void delete(@PathVariable("idOrder") Long id);

}
