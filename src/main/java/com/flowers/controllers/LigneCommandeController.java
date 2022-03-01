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
        LigneCommandeDto ligneCommandeDtoResult = ligneCommandeService.saveOrderItem(ligneCommandeDto);
        return new ResponseEntity<>(ligneCommandeDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LigneCommandeDto> updateLigneCommande(Long id, LigneCommandeDto ligneCommandeDto) {
        ligneCommandeDto.setId(id);
        LigneCommandeDto ligneCommandeDtoResult = ligneCommandeService.saveOrderItem(ligneCommandeDto);
        return new ResponseEntity<>(ligneCommandeDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LigneCommandeDto> getOrderItemById(Long id) {
        LigneCommandeDto ligneCommandeDtoResult = ligneCommandeService.findOrderItemById(id);
        return new ResponseEntity<>(ligneCommandeDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getAllOrderItems() {
        List<LigneCommandeDto> ligneCommandeDtoList = ligneCommandeService.findAllOrderItems();
        return new ResponseEntity<>(ligneCommandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getAllOrderItemOrderByIdDesc() {
        List<LigneCommandeDto> ligneCommandeDtoList = ligneCommandeService.findByOrderByIdDesc();
        return new ResponseEntity<>(ligneCommandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getAllOrderItemsGroupByProductIdDesc() {
        List<LigneCommandeDto> ligneCommandeDtoList = ligneCommandeService.findArticlesGroupByProductId();
        return new ResponseEntity<>(ligneCommandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getAllOrderItemsByOrderId(Long comId) {
        List<LigneCommandeDto> ligneCommandeDtoList = ligneCommandeService.ListOrderItemByOrderId(comId);
        return new ResponseEntity<>(ligneCommandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LigneCommandeDto>> getTop200OrderItemsOrderByIdDesc() {
        List<LigneCommandeDto> ligneCommandeDtoList = ligneCommandeService.findTop200ByOrderByIdDesc();
        return new ResponseEntity<>(ligneCommandeDtoList, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        ligneCommandeService.deleteOrderItem(id);
    }
}
