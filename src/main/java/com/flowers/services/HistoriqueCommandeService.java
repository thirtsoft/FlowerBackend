package com.flowers.services;

import com.flowers.dtos.FournisseurDto;
import com.flowers.dtos.HistoriqueCommandeDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface HistoriqueCommandeService {

    HistoriqueCommandeDto saveHistoriqueCommande(HistoriqueCommandeDto historiqueCommandeDto);

    HistoriqueCommandeDto saveHistoriqueCommandeWithConnectedUser(HistoriqueCommandeDto historiqueCommandeDto, Long userId);

    HistoriqueCommandeDto findHistoriqueCommandeById(Long id);

    List<HistoriqueCommandeDto> findAllHistoriqueCommandes();

    List<HistoriqueCommandeDto> findAllHistoriqueCommandeOrderDesc();

    BigDecimal countNumberOfHistoriqueCommandes();

    void deleteHistorique(Long id);

    List<HistoriqueCommandeDto> findAllActiveHistoriqueCommandes();

    void deleteHistoriqueCommande(Long histComId);
}
