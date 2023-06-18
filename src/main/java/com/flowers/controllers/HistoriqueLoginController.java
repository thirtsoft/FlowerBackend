package com.flowers.controllers;

import com.flowers.controllers.api.HistoriqueLoginApi;
import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.HistoriqueLogin;
import com.flowers.services.HistoriqueLoginService;
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
public class HistoriqueLoginController implements HistoriqueLoginApi {

    private final HistoriqueLoginService historiqueLoginService;

    @Autowired
    public HistoriqueLoginController(HistoriqueLoginService historiqueLoginService) {
        this.historiqueLoginService = historiqueLoginService;
    }


    @Override
    public ResponseEntity<HistoriqueLoginDto> saveHistoriqueLogin(HistoriqueLoginDto historiqueLoginDto) {
        HistoriqueLoginDto historiqueLoginDtoResult = historiqueLoginService.saveHistoriqueLogin(historiqueLoginDto);
        return new ResponseEntity<>(historiqueLoginDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HistoriqueLoginDto> getHistoriqueLoginById(Long id) {
        HistoriqueLoginDto historiqueLoginDtoResult = historiqueLoginService.findHistoriqueLoginById(id);
        return new ResponseEntity<>(historiqueLoginDtoResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HistoriqueLoginDto>> getAllHistoriqueLogins() {
        List<HistoriqueLoginDto> historiqueLoginDtoList = historiqueLoginService.findAllHistoriqueLogins();
        return new ResponseEntity<>(historiqueLoginDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HistoriqueLoginDto>> getAllHistoriqueLoginOrderByIdDesc() {
        List<HistoriqueLoginDto> historiqueLoginDtoList = historiqueLoginService.findAllHistoriqueLoginsOrderDesc();
        return new ResponseEntity<>(historiqueLoginDtoList, HttpStatus.OK);
    }

    @Override
    public BigDecimal countNumberOfHistoriqueLogins() {
        return historiqueLoginService.countNumberOfHistoriqueLogins();
    }

    @Override
    public void delete(Long id) {
        historiqueLoginService.deleteHistoriqueLogin(id);
    }

    @Override
    public ResponseEntity<List<HistoriqueLoginDto>> getAllActiveHistoriqueLogins() {
        List<HistoriqueLoginDto> historiqueLoginDtoList = historiqueLoginService.findAllActiveHistoriqueLogins();
        return new ResponseEntity<>(historiqueLoginDtoList, HttpStatus.OK);
    }

    @Override
    public void deleteHistoriqueLogin(Long idHistLog) {
        historiqueLoginService.deleteHistoriqueLogin(idHistLog);
    }
}
