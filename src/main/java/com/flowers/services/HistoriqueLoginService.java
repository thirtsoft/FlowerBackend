package com.flowers.services;

import com.flowers.dtos.HistoriqueLoginDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface HistoriqueLoginService {

    HistoriqueLoginDto saveHistoriqueLogin(HistoriqueLoginDto historiqueLoginDto);

    HistoriqueLoginDto saveHistoriqueLoginWithConnectedUser(HistoriqueLoginDto historiqueLoginDto, Long userId);

    HistoriqueLoginDto findHistoriqueLoginById(Long id);

    List<HistoriqueLoginDto> findAllHistoriqueLogins();

    List<HistoriqueLoginDto> findAllHistoriqueLoginsOrderDesc();

    BigDecimal countNumberOfHistoriqueLogins();

    void deleteHistoriqueLogin(Long id);
}
