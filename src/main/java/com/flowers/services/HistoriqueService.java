package com.flowers.services;

import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.dtos.HistoriqueLoginDto;

import java.math.BigDecimal;
import java.util.List;

public interface HistoriqueService {

    BigDecimal countNumberOfHistoriqueCommandes();

    List<HistoriqueCommandeDto> findAllActiveHistoriqueCommandes();

    void deleteHistoriqueCommande(Long histComId);

    HistoriqueLoginDto saveHistoriqueLogin(HistoriqueLoginDto historiqueLoginDto);

    BigDecimal countNumberOfHistoriqueLogins();

    List<HistoriqueLoginDto> findAllActiveHistoriqueLogins();

    void deleteHistoriqueLogin(Long histlogId);
}
