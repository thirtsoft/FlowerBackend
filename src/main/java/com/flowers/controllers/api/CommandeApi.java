package com.flowers.controllers.api;

import com.flowers.dtos.ClientDto;
import com.flowers.dtos.CommandeDto;
import com.flowers.models.Commande;
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

public interface CommandeApi {

    @PostMapping(value = APP_ROOT + "/orders/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une commande",
            notes = "Cette méthode permet d'ajouter une commande", response = CommandeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La Country a été crée"),
            @ApiResponse(code = 400, message = "Aucun Country  crée / modifié")
    })
    ResponseEntity<CommandeDto> saveCommande(@RequestBody CommandeDto commandeDto);

    @PutMapping(value = APP_ROOT + "/orders/update/{idOrder}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier une commande par son ID",
            notes = "Cette méthode permet de modifier une commande par son ID", response = CommandeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Country a été modifiée"),
            @ApiResponse(code = 400, message = "La Country a n'est pas modifiée")
    })
    ResponseEntity<CommandeDto> updateCommande(@PathVariable("idOrder") Long id, @RequestBody CommandeDto commandeDto);

    @PatchMapping(value = APP_ROOT + "/orders/updateStatusOfOrder/{id}")
    @ApiOperation(value = "Modifier une Commande par son Status",
            notes = "Cette méthode permet de modifier une Commande par son Status", response = CommandeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le status de la Commande a été modifié")
    })
    ResponseEntity<CommandeDto> updateStatusOfOrder(@RequestParam("status") String status, @PathVariable("id") String id);

    @GetMapping(value = APP_ROOT + "/orders/findById/{idOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une commande par ID",
            notes = "Cette méthode permet de chercher une commande par son ID", response = CommandeDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Country n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<CommandeDto> getCommandeById(@PathVariable("idOrder") Long id);

    @GetMapping(value = APP_ROOT + "/orders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandes();

    @GetMapping(value = APP_ROOT + "/orders/searchAllOrdersOrderByIdDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Articles par ordre descroissante",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Articles par ordre descroissante",
            responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Articles  par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesOrderByIdDesc();

    @GetMapping(value = APP_ROOT + "/orders/findListOrderByStatuePending", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes dont le status encours",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes dont le status est encours", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesByStatusPending();

    @GetMapping(value = APP_ROOT + "/orders/findListOrderByStatuePayed", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes payees",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes payees", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes payees / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesByStatusPayed();

    @GetMapping(value = APP_ROOT + "/orders/searchOrderByUserIdOrderByIdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesByUserOrderByIdDesc(@PathVariable(name = "id") Long id);

    @GetMapping(value = APP_ROOT + "/orders/searchOrderByBillingAddressIdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandessByBillingAddressOrderByIdDesc(@PathVariable(name = "id") Long id);

    @GetMapping(value = APP_ROOT + "/orders/searchOrderByShippingAddressIdDesc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commandes par user",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commandes par user", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commandes par user / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllCommandesByShippingAddressByIdDesc(@PathVariable(name = "id") Long id);

    @GetMapping(value = APP_ROOT + "/orders/countNumberOfOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Commande",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Commande")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Commande / le nombre est nulle")
    })
    BigDecimal countNumberOfOrder();

    @GetMapping(value = APP_ROOT + "/orders/countNumberOfOrdersInMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Commande du mois",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Commande du mois")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Commande / le nombre est nulle")
    })
    BigDecimal countNumberOfOrdersInMonth();

    @GetMapping(value = APP_ROOT + "/orders/countNumberOfOrdersByPendingStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de Commande encours",
            notes = "Cette méthode permet de chercher et renvoyer le nombre de Commande encours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le nombre de Commande / le nombre est nulle")
    })
    BigDecimal countNumberOfCommandesByStatusPending();

    @GetMapping(value = APP_ROOT + "/orders/sumTotalOfOrderByDay", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le montant de Commande du jour",
            notes = "Cette méthode permet de chercher et renvoyer le montant de Commande du jour encours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le montant des Commande par jour / somme nulle")
    })
    BigDecimal sumTotaleOfCommandesByDay();

    @GetMapping(value = APP_ROOT + "/orders/sumTotalOfOrderByMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le montant de Commande du moi",
            notes = "Cette méthode permet de chercher et renvoyer le montant de Commande du moi encours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le montant des Commande par moi / somme nulle")
    })
    BigDecimal sumTotaleOfCommandesByMonth();

    @GetMapping(value = APP_ROOT + "/orders/sumTotalOfOrderByYear", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le montant de Commande d'une années",
            notes = "Cette méthode permet de chercher et renvoyer le montant de Commande de l'année encours")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le montant des Commande par années / somme nulle")
    })
    BigDecimal sumTotaleOfCommandesByYear();

    @GetMapping(value = APP_ROOT + "/orders/numberOfOrderByDay", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste du nombre de Commandes par jour",
            notes = "Cette méthode permet de chercher et renvoyer la liste du nombre de Commandes par jour", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste du nombre de Commandes par jour / une liste vide")
    })
    List<?> countNumberOfOrderByDay();

    @GetMapping(value = APP_ROOT + "/orders/numberOfOrderByMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste du nombre de Commandes par moi",
            notes = "Cette méthode permet de chercher et renvoyer la liste du nombre de Commandes par moi", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste du nombre de Commandes par moi / une liste vide")
    })
    List<?> countNumberOfOrderByMonth();

    @GetMapping(value = APP_ROOT + "/orders/sumTotaleOfOrderByMonthByList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des sommes des Commandes par moi",
            notes = "Cette méthode permet de chercher et renvoyer liste des somme des Commandes par moi", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des sommes des Commandes par moi / une liste vide")
    })
    List<?> getSumTotaleOfOrderByMonth();

    @GetMapping(value = APP_ROOT + "/orders/sumTotaleOfOrderByYearList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des sommes des Commandes par années",
            notes = "Cette méthode permet de chercher et renvoyer liste des somme des Commandes par années", responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des sommes des Commandes par années / une liste vide")
    })
    List<?> getSumTotalOfOrdersByYears();

    @GetMapping(value = APP_ROOT + "/orders/searchOrdersByUtilisateurIdByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Commande par client",
            notes = "Cette méthode permet de chercher et renvoyer la liste des Commande par Client par pages", responseContainer = "Page<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Commande par Client par pages / une liste vide")
    })
    Page<CommandeDto> getOrdersByUtilisateurIdByPageables(@RequestParam("userId") Long userId, @RequestParam(name = "page") int page,
                                                       @RequestParam(name = "size") int size);

    @DeleteMapping(value = APP_ROOT + "/orders/delete/{idOrder}")
    @ApiOperation(value = "Supprimer une Commande par son ID",
            notes = "Cette méthode permet de supprimer une Commande par son ID", response = CommandeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La CommandeDto a été supprimé")
    })
    void delete(@PathVariable("idOrder") Long id);

    @GetMapping(value = APP_ROOT + "/orders/search-all-active-orders", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des orders actives",
            notes = "Cette méthode permet de chercher et renvoyer la liste des orders actives",
            responseContainer = "List<CommandeDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des orders par ordre descroissante / une liste vide")
    })
    ResponseEntity<List<CommandeDto>> getAllActiveCommandes();

    @DeleteMapping(value = APP_ROOT + "/orders/delete-order/{idOrder}")
    @ApiOperation(value = "Supprimer un order par son ID",
            notes = "Cette méthode permet de supprimer un order  par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le order a été supprimé")
    })
    void deleteCommande(@PathVariable("idOrder") Long idOrder);

}
