package com.flowers.controllers;

import com.flowers.controllers.api.CommandeApi;
import com.flowers.dtos.CommandeDto;
import com.flowers.services.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = {"https://fleurpourtous.com", "https://portail.fleurpourtous.com"})
//@CrossOrigin(origins = "http://localhost:4200, http://localhost:3200")
@RestController
@AllArgsConstructor
public class CommandeController implements CommandeApi {

    private final CommandeService commandeService;

    @Override
    public ResponseEntity<CommandeDto> updateStatusOfOrder(String status, String id) {
        CommandeDto newCommandeDto = commandeService.updateStatusOfOrder(status, id);
        return new ResponseEntity<>(newCommandeDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeDto> getCommandeById(Long id) {
        CommandeDto newCommandeDto = commandeService.findOrderById(id);
        return new ResponseEntity<>(newCommandeDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesByStatusPending() {
        List<CommandeDto> commandeDtoList = commandeService.findListOrderByStatusPending();
        return new ResponseEntity<>(commandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesByStatusPayed() {
        List<CommandeDto> commandeDtoList = commandeService.findListOrderByStatusPayed();
        return new ResponseEntity<>(commandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesByUserOrderByIdDesc(Long id) {
        List<CommandeDto> commandeDtoList = commandeService.findListOrderByCustomerId(id);
        return new ResponseEntity<>(commandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandessByBillingAddressOrderByIdDesc(Long id) {
        List<CommandeDto> commandeDtoList = commandeService.findListOrderByAddressLivraisonId(id);
        return new ResponseEntity<>(commandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesByShippingAddressByIdDesc(Long id) {
        List<CommandeDto> commandeDtoList = commandeService.findListOrderByAddressAchatId(id);
        return new ResponseEntity<>(commandeDtoList, HttpStatus.OK);
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
    public BigDecimal countNumberOfCommandesByStatusPending() {
        return commandeService.countNumberOfOrdersByStatusPending();
    }

    @Override
    public BigDecimal sumTotaleOfCommandesByDay() {
        return commandeService.sumTotalOfOrderByDay();
    }

    @Override
    public BigDecimal sumTotaleOfCommandesByMonth() {
        return commandeService.sumTotaleOfOrderByMonth();
    }

    @Override
    public BigDecimal sumTotaleOfCommandesByYear() {
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
    public Page<CommandeDto> getOrdersByUtilisateurIdByPageables(Long userId, int page, int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return commandeService.findCommandeByUtilisateurPageables(userId, pageable);
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllActiveCommandes() {
        List<CommandeDto> commandeDtoList = commandeService.findAllActiveCommandes();
        return new ResponseEntity<>(commandeDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteCommande(Long idOrder) {
        commandeService.deleteCommande(idOrder);
    }
}
