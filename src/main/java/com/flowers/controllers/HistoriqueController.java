package com.flowers.controllers;

import com.flowers.controllers.api.HistoriqueApi;
import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.services.HistoriqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "https://portail.fleurpourtous.com")
//@CrossOrigin
@RestController
public class HistoriqueController implements HistoriqueApi {

    private final HistoriqueService historiqueService;

    public HistoriqueController(HistoriqueService historiqueService) {
        this.historiqueService = historiqueService;
    }

    @Override
    public BigDecimal countNumberOfHistoriqueCommandeDtos() {
        return historiqueService.countNumberOfHistoriqueCommandes();
    }

    @Override
    public ResponseEntity<List<HistoriqueCommandeDto>> getAllActiveHistoriqueCommandes() {
        List<HistoriqueCommandeDto> historiqueCommandeDtoList = historiqueService.findAllActiveHistoriqueCommandes();
        return new ResponseEntity<>(historiqueCommandeDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteHistoriqueCommande(Long idHistCom) {
        historiqueService.deleteHistoriqueCommande(idHistCom);
    }

    @Override
    public BigDecimal countNumberOfHistoriqueLogins() {
        return historiqueService.countNumberOfHistoriqueLogins();
    }

    @Override
    public ResponseEntity<List<HistoriqueLoginDto>> getAllActiveHistoriqueLogins() {
        List<HistoriqueLoginDto> historiqueLoginDtoList = historiqueService.findAllActiveHistoriqueLogins();
        return new ResponseEntity<>(historiqueLoginDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteHistoriqueLogin(Long idHistLog) {
        historiqueService.deleteHistoriqueLogin(idHistLog);
    }
}
