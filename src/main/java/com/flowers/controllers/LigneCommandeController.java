package com.flowers.controllers;

import com.flowers.controllers.api.LigneCommandeApi;
import com.flowers.dtos.LigneCommandeDto;
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
public class LigneCommandeController implements LigneCommandeApi {

    private final LigneCommandeService ligneCommandeService;

    @Override
    public ResponseEntity<LigneCommandeDto> saveLigneCommande(LigneCommandeDto ligneCommandeDto) {
        return null;
    }

    @Override
    public ResponseEntity<LigneCommandeDto> updateLigneCommande(Long id, LigneCommandeDto ligneCommandeDto) {
        return null;
    }

    @Override
    public ResponseEntity<LigneCommandeDto> getOrderItemById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getAllOrderItems() {
        return null;
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getAllOrderItemOrderByIdDesc() {
        return null;
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getAllOrderItemsGroupByProductIdDesc() {
        return null;
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getAllOrderItemsByOrderId(Long comId) {
        return null;
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getTop200OrderItemsOrderByIdDesc() {
        return null;
    }

    @Override
    public void delete(Long id) {
        ligneCommandeService.deleteOrderItem(id);
    }
}
