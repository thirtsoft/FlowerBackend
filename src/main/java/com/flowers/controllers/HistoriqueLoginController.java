package com.flowers.controllers;

import com.flowers.controllers.api.HistoriqueLoginApi;
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
    public ResponseEntity<HistoriqueLogin> save(HistoriqueLogin historiqueLogin) {
        return ResponseEntity.ok(historiqueLoginService.saveHistoriqueLogin(historiqueLogin));
    }

    @Override
    public ResponseEntity<HistoriqueLogin> findById(Long id) {
        HistoriqueLogin historiqueLogin = historiqueLoginService.findHistoriqueLoginById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HistoriqueLogin not found"));
        return ResponseEntity.ok().body(historiqueLogin);
    }

    @Override
    public ResponseEntity<List<HistoriqueLogin>> findAll() {
        List<HistoriqueLogin> historiqueLoginList = historiqueLoginService.findAllHistoriqueLogins();
        return new ResponseEntity<>(historiqueLoginList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HistoriqueLogin>> getAllHistoriqueLoginOrderByIdDesc() {
        List<HistoriqueLogin> historiqueLoginList = historiqueLoginService.findAllHistoriqueLoginsOrderDesc();
        return new ResponseEntity<>(historiqueLoginList, HttpStatus.OK);
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
