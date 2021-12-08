package com.flowers.controllers.api;

import com.flowers.models.Category;
import com.flowers.models.Country;
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

    @GetMapping(value = APP_ROOT + "/orders/findById/{idOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une commande par ID",
            notes = "Cette méthode permet de chercher une commande par son ID", response = Order.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La v a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Country n'existe avec cette ID pas dans la BD")
    })
    ResponseEntity<Order> findById(@PathVariable("idOrder") Long id);

    @GetMapping(value = APP_ROOT + "/orders/countNumberOfOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Compter le nombre de commande",
            notes = "Cette méthode permet de Compter le nombre de commande", response = Order.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La v a été trouver"),
            @ApiResponse(code = 404, message = "Aucun Order n'existe avec cette ID pas dans la BD")
    })
    BigDecimal countNumberOfOrder();

    @GetMapping(value = APP_ROOT + "/orders/sumTotalOfOrderByMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    BigDecimal sumTotaleOfOrderByMonth();

    @GetMapping(value = APP_ROOT + "/orders/sumTotalOfOrderByYear", produces = MediaType.APPLICATION_JSON_VALUE)
    BigDecimal sumTotaleOfOrderByYear();

    @GetMapping(value = APP_ROOT + "/orders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Order> findAll();

    @GetMapping(value = APP_ROOT + "/orders/numberOfOrderByMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    List<?> countNumberOfOrderByMonth();

    @GetMapping(value = APP_ROOT + "/orders/sumTotaleOfOrderByMonthByList", produces = MediaType.APPLICATION_JSON_VALUE)
    List<?> getSumTotaleOfOrderByMonth();

    @GetMapping(value = APP_ROOT + "/orders/searchOrderByCustomerByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    Page<Order> getListOrderByCustomerByPageables(@RequestParam("clientId") Long clientId, @RequestParam(name = "page") int page,
                                                  @RequestParam(name = "size") int size);

    @GetMapping(value = APP_ROOT + "/orders/searchOrderByUtilisateurByPageables", produces = MediaType.APPLICATION_JSON_VALUE)
    Page<Order> getListOrderByUtilisateurByPageables(@RequestParam("userId") Long userId, @RequestParam(name = "page") int page,
                                                     @RequestParam(name = "size") int size);

    @DeleteMapping(value = APP_ROOT + "/orders/delete/{idOrder}")
    void delete(@PathVariable("idOrder") Long id);
}
