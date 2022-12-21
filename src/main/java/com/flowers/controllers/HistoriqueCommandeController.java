package com.flowers.controllers;

import com.flowers.controllers.api.HistoriqueCommandeApi;
import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.services.HistoriqueCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "https://portail.fleurpourtous.com")
//@CrossOrigin
@RestController
public class HistoriqueCommandeController implements HistoriqueCommandeApi {

    private final HistoriqueCommandeService historiqueCommandeService;

    @Autowired
    public HistoriqueCommandeController(HistoriqueCommandeService historiqueCommandeService) {
        this.historiqueCommandeService = historiqueCommandeService;
    }

    @Override
    public ResponseEntity<HistoriqueCommandeDto> save(HistoriqueCommandeDto historiqueCommandeDto) {
        HistoriqueCommandeDto historiqueCommandeDtoResult = historiqueCommandeService.saveHistoriqueCommande(historiqueCommandeDto);
        return new ResponseEntity<>(historiqueCommandeDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HistoriqueCommandeDto> getHistoriqueCommqndeById(Long id) {
        HistoriqueCommandeDto historiqueCommandeDtoResult = historiqueCommandeService.findHistoriqueCommandeById(id);
        return new ResponseEntity<>(historiqueCommandeDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HistoriqueCommandeDto>> getAllHistoriqueCommqndes() {
        List<HistoriqueCommandeDto> historiqueCommandeDtoList = historiqueCommandeService.findAllHistoriqueCommandes();
        return new ResponseEntity<>(historiqueCommandeDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HistoriqueCommandeDto>> getAllHistoriqueCommandesOrderByIdDesc() {
        List<HistoriqueCommandeDto> historiqueCommandeDtoList = historiqueCommandeService.findAllHistoriqueCommandeOrderDesc();
        return new ResponseEntity<>(historiqueCommandeDtoList, HttpStatus.OK);
    }

    @Override
    public BigDecimal countNumberOfHistoriqueCommandeDtos() {
        return historiqueCommandeService.countNumberOfHistoriqueCommandes();
    }

    @Override
    public void delete(Long id) {
        historiqueCommandeService.deleteHistoriqueCommande(id);
    }
}
