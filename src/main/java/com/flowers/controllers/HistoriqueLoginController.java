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

@CrossOrigin
@RestController
public class HistoriqueLoginController implements HistoriqueLoginApi {

    private final HistoriqueLoginService historiqueLoginService;

    @Autowired
    public HistoriqueLoginController(HistoriqueLoginService historiqueLoginService) {
        this.historiqueLoginService = historiqueLoginService;
    }


    @Override
    public ResponseEntity<HistoriqueLoginDto> saveHistoriqueLogin(HistoriqueLoginDto historiqueLoginDto) {
        return null;
    }

    @Override
    public ResponseEntity<HistoriqueLoginDto> getHistoriqueLoginById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<HistoriqueLoginDto>> getAllHistoriqueLogins() {
        return null;
    }

    @Override
    public ResponseEntity<List<HistoriqueLoginDto>> getAllHistoriqueLoginOrderByIdDesc() {
        return null;
    }

    @Override
    public BigDecimal countNumberOfHistoriqueLogins() {
        return historiqueLoginService.countNumberOfHistoriqueLogins();
    }

    @Override
    public void delete(Long id) {
        historiqueLoginService.deleteHistoriqueLogin(id);
    }
}
