package com.flowers.controllers;

import com.flowers.controllers.api.OrderApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Commande;
import com.flowers.services.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class OrderController implements OrderApi {

    private final CommandeService commandeService;

    @Override
    public ResponseEntity<Commande> save(Commande commande) {
        return ResponseEntity.ok(commandeService.saveOrder(commande));
    }

    @Override
    public ResponseEntity<Commande> update(Long id, Commande commande) {
        commande.setId(id);
        return ResponseEntity.ok(commandeService.saveOrder(commande));
    }

    @Override
    public ResponseEntity<Commande> updateStatusOfOrder(String status, String id) {
        Commande newCommande = commandeService.updateStatusOfOrder(status, id);
        return new ResponseEntity<>(newCommande, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Commande> getById(Long id) {
        Commande commande = commandeService.findOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return ResponseEntity.ok().body(commande);
    }

    @Override
    public ResponseEntity<List<Commande>> getAll() {
        List<Commande> commandeList = commandeService.findAllOrders();
        return new ResponseEntity<>(commandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Commande>> getAllOrdersOrderByIdDesc() {
        List<Commande> commandeList = commandeService.findByOrderByIdDesc();
        return new ResponseEntity<>(commandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Commande>> getListOrderByStatusPending() {
        List<Commande> commandeList = commandeService.findListOrderByStatusPending();
        return new ResponseEntity<>(commandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Commande>> getListOrderByStatusPayed() {
        List<Commande> commandeList = commandeService.findListOrderByStatusPayed();
        return new ResponseEntity<>(commandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Commande>> getOrdersByUserOrderByIdDesc(Long id) {
        List<Commande> commandeList = commandeService.findListOrderByCustomerId(id);
        return new ResponseEntity<>(commandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Commande>> getOrdersByBillingAddressOrderByIdDesc(Long id) {
        List<Commande> commandeList = commandeService.findListOrderByAddressLivraisonId(id);
        return new ResponseEntity<>(commandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Commande>> getOrdersByShippingAddressByIdDesc(Long id) {
        List<Commande> commandeList = commandeService.findListOrderByAddressAchatId(id);
        return new ResponseEntity<>(commandeList, HttpStatus.OK);
    }

    @Override
    public BigDecimal countNumberOfOrder() {
        return commandeService.countNumberOfOrder();
    }

    @Override
    public BigDecimal countNumberOfOrdersInMonth() {
        return commandeService.countNumberOfOrdersInMonth();
    }

    @Override
    public BigDecimal countNumberOfOrdersByStatusPending() {
        return commandeService.countNumberOfOrdersByStatusPending();
    }

    @Override
    public BigDecimal sumTotaleOfOrderByDay() {
        return commandeService.sumTotalOfOrderByDay();
    }

    @Override
    public BigDecimal sumTotaleOfOrderByMonth() {
        return commandeService.sumTotaleOfOrderByMonth();
    }

    @Override
    public BigDecimal sumTotaleOfOrderByYear() {
        return commandeService.sumTotalOfOrdersByYear();
    }

    @Override
    public List<?> countNumberOfOrderByDay() {
        return commandeService.countNumberOfOrderByDay();
    }

    @Override
    public List<?> countNumberOfOrderByMonth() {
        return commandeService.countNumberTotalOfOrderByMonth();
    }

    @Override
    public List<?> getSumTotaleOfOrderByMonth() {
        return commandeService.sumTotalOfOrderByMonth();
    }

    @Override
    public List<?> getSumTotalOfOrdersByYears() {
        return commandeService.sumTotalOfOrdersByYears();
    }


    @Override
    public Page<Commande> getOrdersByUtilisateurIdByPageables(Long userId, int page, int size) {
        return null;
    }

    @Override
    public void delete(Long id) {
        commandeService.deleteOrder(id);
    }
}
