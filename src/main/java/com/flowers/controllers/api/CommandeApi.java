package com.flowers.controllers.api;

import com.flowers.dtos.CommandeDto;
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

@RequestMapping(value = APP_ROOT + "/orders")
public interface CommandeApi {

    @PatchMapping(value = "/update-status-of-order/{id}")
    @ApiOperation(value = "Modifier une Commande par son Status",
            notes = "Cette méthode permet de modifier une Commande par son Status", response = CommandeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le status de la Commande a été modifié")
    })
    ResponseEntity<CommandeDto> updateStatusOfOrder(@RequestParam("status") String status, @PathVariable("id") String id);

    @GetMapping(value = "/findById/{idOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une commande par ID",
            notes = "Cette méthode permet de chercher une commande par son ID", response = CommandeDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Country n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<CommandeDto> getCommandeById(@PathVariable("idOrder") Long id);

    @GetMapping(value = "/find-list-order-by-status-pending", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes dont le status encours",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes dont le status est encours", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesByStatusPending();

    @GetMapping(value = "/find-list-order-by-status-payed", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes payees",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes payees", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes payees / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesByStatusPayed();

    @GetMapping(value = "/search-order-by-userId-order-by-IdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesByUserOrderByIdDesc(@PathVariable(name = "id") Long id);

    @GetMapping(value = "/search-order-by-billing-addressIdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandessByBillingAddressOrderByIdDesc(@PathVariable(name = "id") Long id);

    @GetMapping(value = "/search-order-by-shipping-addressIdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesByShippingAddressByIdDesc(@PathVariable(name = "id") Long id);

    @GetMapping(value = "/count-number-of-order", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Commande",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Commande")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Commande / le nombre est nulle")
    })
    BigDecimal countNumberOfOrder();

    @GetMapping(value = "/count-number-of-orders-in-month", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Commande du mois",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Commande du mois")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Commande / le nombre est nulle")
    })
    BigDecimal countNumberOfOrdersInMonth();

    @GetMapping(value = "/count-number-of-orders-by-pending-status", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Commande encours",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Commande encours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Commande / le nombre est nulle")
    })
    BigDecimal countNumberOfCommandesByStatusPending();

    @GetMapping(value = "/sum-total-of-order-by-day", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le montant de Commande du jour",
            notes = "Cette méthode permet de chercher et renvoyer le montant de Commande du jour encours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le montant des Commande par jour / somme nulle")
    })
    BigDecimal sumTotaleOfCommandesByDay();

    @GetMapping(value = "/sum-total-of-order-by-month", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le montant de Commande du moi",
            notes = "Cette méthode permet de chercher et renvoyer le montant de Commande du moi encours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le montant des Commande par moi / somme nulle")
    })
    BigDecimal sumTotaleOfCommandesByMonth();

    @GetMapping(value = "/sum-total-of-order-by-year", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le montant de Commande d'une années",
            notes = "Cette méthode permet de chercher et renvoyer le montant de Commande de l'année encours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le montant des Commande par années / somme nulle")
    })
    BigDecimal sumTotaleOfCommandesByYear();

    @GetMapping(value = "/number-of-order-by-day", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste du nombre de Commandes par jour",
            notes = "Cette méthode permet de chercher et renvoyer la liste du nombre de Commandes par jour", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste du nombre de Commandes par jour / une liste vide")
    })
    List<?> countNumberOfOrderByDay();

    @GetMapping(value = "/number-of-order-by-month", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste du nombre de Commandes par moi",
            notes = "Cette méthode permet de chercher et renvoyer la liste du nombre de Commandes par moi", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste du nombre de Commandes par moi / une liste vide")
    })
    List<?> countNumberOfOrderByMonth();

    @GetMapping(value = "/sum-total-of-order-by-month-by-list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des sommes des Commandes par moi",
            notes = "Cette méthode permet de chercher et renvoyer liste des somme des Commandes par moi", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des sommes des Commandes par moi / une liste vide")
    })
    List<?> getSumTotaleOfOrderByMonth();

    @GetMapping(value = "/sum-total-of-order-by-year-list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des sommes des Commandes par années",
            notes = "Cette méthode permet de chercher et renvoyer liste des somme des Commandes par années", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des sommes des Commandes par années / une liste vide")
    })
    List<?> getSumTotalOfOrdersByYears();

    @GetMapping(value = "/search-orders-by-userId-by-pageable", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commande par client",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commande par Client par pages", responseContainer = "Page<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commande par Client par pages / une liste vide")
    })
    Page<CommandeDto> getOrdersByUtilisateurIdByPageables(@RequestParam("userId") Long userId, @RequestParam(name = "page") int page,
                                                          @RequestParam(name = "size") int size);

    @GetMapping(value = "/search-all-active-orders", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des orders actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des orders actives",
            responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des orders par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllActiveCommandes();

    @DeleteMapping(value = "/delete-order/{idOrder}")
    @ApiOperation(value = "Supprimer un order par son ID",
            notes = "Cette méthode permet de supprimer un order  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le order a été supprimé")
    })
    void deleteCommande(@PathVariable("idOrder") Long idOrder);

    @PatchMapping(value = "/payer-order/{id}")
    @ApiOperation(value = "Modifier status commande à payer",
            notes = "Cette méthode permet de modifier le status de la Commande à payée")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le status de la Commande a été modifié")
    })
    ResponseEntity payerOrder(@PathVariable("id") Long id);

    @PatchMapping(value = "/valider-order/{id}")
    @ApiOperation(value = "Modifier status commande à valider",
            notes = "Cette méthode permet de modifier le status de la Commande à valider")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le status de la Commande a été modifié")
    })
    ResponseEntity validerOrder(@PathVariable("id") Long id);

    @PatchMapping(value = "/rejeter-order/{id}")
    @ApiOperation(value = "Modifier status commande à rejetée",
            notes = "Cette méthode permet de modifier le status de la Commande à rejetée")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le status de la Commande a été modifié")
    })
    ResponseEntity rejeterOrder(@PathVariable("id") Long id);

    @PatchMapping(value = "/annuler-order/{id}")
    @ApiOperation(value = "Modifier status commande à anullée",
            notes = "Cette méthode permet de modifier le status de la Commande à anullée")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le status de la Commande a été modifié")
    })
    ResponseEntity annulerOrder(@PathVariable("id") Long id);

}