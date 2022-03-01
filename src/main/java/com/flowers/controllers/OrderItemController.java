package com.flowers.controllers;

import com.flowers.controllers.api.OrderItemApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.LigneCommande;
import com.flowers.services.LigneCommandeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderItemController implements OrderItemApi {

    private final LigneCommandeService ligneCommandeService;

    @Override
    public ResponseEntity<LigneCommande> save(LigneCommande ligneCommande) {
        return ResponseEntity.ok(ligneCommandeService.saveOrderItem(ligneCommande));
    }

    @Override
    public ResponseEntity<LigneCommande> update(Long id, LigneCommande ligneCommande) {
        ligneCommande.setId(id);
        return ResponseEntity.ok(ligneCommandeService.saveOrderItem(ligneCommande));
    }

    @Override
    public ResponseEntity<LigneCommande> getOrderItemById(Long id) {
        LigneCommande ligneCommande = ligneCommandeService.findOrderItemById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found"));
        return ResponseEntity.ok().body(ligneCommande);
    }

    @Override
    public ResponseEntity<List<LigneCommande>> getAllOrderItems() {
        List<LigneCommande> ligneCommandeList = ligneCommandeService.findAllOrderItems();
        return new ResponseEntity<>(ligneCommandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommande>> getAllOrderItemOrderByIdDesc() {
        List<LigneCommande> ligneCommandeList = ligneCommandeService.findByOrderByIdDesc();
        return new ResponseEntity<>(ligneCommandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommande>> getAllOrderItemsGroupByProductIdDesc() {
        List<LigneCommande> ligneCommandeList = ligneCommandeService.findArticlesGroupByProductId();
        return new ResponseEntity<>(ligneCommandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommande>> getAllOrderItemsByOrderId(Long comId) {
        List<LigneCommande> ligneCommandeList = ligneCommandeService.ListOrderItemByOrderId(comId);
        return new ResponseEntity<>(ligneCommandeList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommande>> getTop200OrderItemsOrderByIdDesc() {
        List<LigneCommande> ligneCommandeList = ligneCommandeService.findTop200ByOrderByIdDesc();
        return new ResponseEntity<>(ligneCommandeList, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        ligneCommandeService.deleteOrderItem(id);
    }
}
