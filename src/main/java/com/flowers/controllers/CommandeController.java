package com.flowers.controllers;

import com.flowers.controllers.api.CommandeApi;
import com.flowers.dtos.CommandeDto;
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
public class CommandeController implements CommandeApi {

    private final CommandeService commandeService;


    @Override
    public ResponseEntity<CommandeDto> saveCommande(CommandeDto commandeDto) {
        return null;
    }

    @Override
    public ResponseEntity<CommandeDto> updateCommande(Long id, CommandeDto commandeDto) {
        return null;
    }

    @Override
    public ResponseEntity<CommandeDto> updateStatusOfOrder(String status, String id) {
        return null;
    }

    @Override
    public ResponseEntity<CommandeDto> getCommandeById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandes() {
        return null;
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesOrderByIdDesc() {
        return null;
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesByStatusPending() {
        return null;
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesByStatusPayed() {
        return null;
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesByUserOrderByIdDesc(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandessByBillingAddressOrderByIdDesc(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesByShippingAddressByIdDesc(Long id) {
        return null;
    }

    @Override
    public BigDecimal countNumberOfOrder() {
        return null;
    }

    @Override
    public BigDecimal countNumberOfOrdersInMonth() {
        return null;
    }

    @Override
    public BigDecimal countNumberOfCommandesByStatusPending() {
        return null;
    }

    @Override
    public BigDecimal sumTotaleOfCommandesByDay() {
        return null;
    }

    @Override
    public BigDecimal sumTotaleOfCommandesByMonth() {
        return null;
    }

    @Override
    public BigDecimal sumTotaleOfCommandesByYear() {
        return null;
    }

    @Override
    public List<?> countNumberOfOrderByDay() {
        return null;
    }

    @Override
    public List<?> countNumberOfOrderByMonth() {
        return null;
    }

    @Override
    public List<?> getSumTotaleOfOrderByMonth() {
        return null;
    }

    @Override
    public List<?> getSumTotalOfOrdersByYears() {
        return null;
    }

    @Override
    public Page<CommandeDto> getOrdersByUtilisateurIdByPageables(Long userId, int page, int size) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
