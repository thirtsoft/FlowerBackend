package com.flowers.controllers;

import com.flowers.controllers.api.CommandeApi;
import com.flowers.dtos.CommandeDto;
import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.services.CommandeService;
import com.flowers.services.HistoriqueCommandeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200, http://localhost:3200")
public class CommandeController implements CommandeApi {

    private final CommandeService commandeService;

    @Autowired
    private HistoriqueCommandeService historiqueCommandeService;


    @Override
    public ResponseEntity<CommandeDto> saveCommande(CommandeDto commandeDto) {

        CommandeDto commandeDtoResult = commandeService.saveOrder(commandeDto);

        HistoriqueCommandeDto historiqueCommandeDto = new HistoriqueCommandeDto();
        historiqueCommandeDto.setCommandeDto(commandeDtoResult);
        historiqueCommandeDto.setAction("AJOUT COMMANDE");
        historiqueCommandeDto.setCreatedDate(new Date());
        historiqueCommandeService.saveHistoriqueCommande(historiqueCommandeDto);

        return new ResponseEntity<>(commandeDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CommandeDto> updateCommande(Long id, CommandeDto commandeDto) {
        commandeDto.setId(id);
        CommandeDto commandeDtoResult = commandeService.saveOrder(commandeDto);

        HistoriqueCommandeDto historiqueCommandeDto = new HistoriqueCommandeDto();
        historiqueCommandeDto.setCommandeDto(commandeDtoResult);
        historiqueCommandeDto.setAction("MODIFICATION COMMANDE");
        historiqueCommandeDto.setCreatedDate(new Date());
        historiqueCommandeService.saveHistoriqueCommande(historiqueCommandeDto);

        return new ResponseEntity<>(commandeDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeDto> updateStatusOfOrder(String status, String id) {
        CommandeDto newCommandeDto = commandeService.updateStatusOfOrder(status, id);

        HistoriqueCommandeDto historiqueCommandeDto = new HistoriqueCommandeDto();
        historiqueCommandeDto.setCommandeDto(newCommandeDto);
        historiqueCommandeDto.setAction("MODIFICATION STATUS COMMANDE");
        historiqueCommandeDto.setCreatedDate(new Date());
        historiqueCommandeService.saveHistoriqueCommande(historiqueCommandeDto);

        return new ResponseEntity<>(newCommandeDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeDto> getCommandeById(Long id) {
        CommandeDto newCommandeDto = commandeService.findOrderById(id);
        return new ResponseEntity<>(newCommandeDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandes() {
        List<CommandeDto> commandeDtoList = commandeService.findAllOrders();
        return new ResponseEntity<>(commandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CommandeDto>> getAllCommandesOrderByIdDesc() {
        List<CommandeDto> commandeDtoList = commandeService.findByOrderByIdDesc();
        return new ResponseEntity<>(commandeDtoList, HttpStatus.OK);
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
    public void delete(Long id) {

        CommandeDto newCommandeDto = commandeService.findOrderById(id);

        HistoriqueCommandeDto historiqueCommandeDto = new HistoriqueCommandeDto();
        historiqueCommandeDto.setCommandeDto(newCommandeDto);
        historiqueCommandeDto.setAction("SUPPRESSION COMMANDE");
        historiqueCommandeDto.setCreatedDate(new Date());
        historiqueCommandeService.saveHistoriqueCommande(historiqueCommandeDto);

        commandeService.deleteOrder(id);



    }
}
