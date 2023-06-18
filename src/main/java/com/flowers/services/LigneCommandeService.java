package com.flowers.services;

import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.dtos.LigneCommandeDto;

import java.util.List;

public interface LigneCommandeService {

    LigneCommandeDto saveOrderItem(LigneCommandeDto ligneCommandeDto);

    LigneCommandeDto findOrderItemById(Long id);

    LigneCommandeDto updateOrderItem(Long Id, LigneCommandeDto ligneCommandeDto);

    List<LigneCommandeDto> findAllOrderItems();

    List<LigneCommandeDto> findArticlesGroupByProductId();

    List<LigneCommandeDto> findByOrderByIdDesc();

    List<LigneCommandeDto> ListOrderItemByOrderId(Long comId);

    List<LigneCommandeDto> findTop200ByOrderByIdDesc();

    List<LigneCommandeDto> findTop8ByOrderByIdDesc();

    List<LigneCommandeDto> findTop3ByOrderByIdDesc();

    void deleteOrderItem(Long Id);

    List<LigneCommandeDto> findAllActiveLigneCommandes();

    void deleteLigneCommande(Long lcomId);

}
