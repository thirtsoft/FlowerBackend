package com.flowers.services;

import com.flowers.dtos.CommandeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeService {

    CommandeDto updateStatusOfOrder(String status, String id);

    CommandeDto findOrderById(Long id);

    List<CommandeDto> findListOrderByStatusPending();

    List<CommandeDto> findListOrderByStatusPayed();

    List<CommandeDto> findListOrderByCustomerId(Long userId);

    List<CommandeDto> findListOrderByAddressLivraisonId(Long addLivraison);

    List<CommandeDto> findListOrderByAddressAchatId(Long addAchat);

    BigDecimal countNumberOfOrder();

    BigDecimal countNumberOfOrdersInMonth();

    BigDecimal sumTotalOfOrderByDay();

    BigDecimal sumTotaleOfOrderByMonth();

    BigDecimal countNumberOfOrdersByStatusPending();

    BigDecimal sumTotalOfOrdersByYear();

    List<?> countNumberOfOrderByDay();

    List<?> countNumberTotalOfOrderByMonth();

    List<?> sumTotalOfOrderByMonth();

    List<?> sumTotalOfOrdersByYears();

    Page<CommandeDto> findCommandeByUtilisateurPageables(Long userId, Pageable pageable);

    List<CommandeDto> findAllActiveCommandes();

    void deleteCommande(Long comId);

}
