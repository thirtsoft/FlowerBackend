package com.flowers.services;

import com.flowers.dtos.LigneCommandeDto;
import com.flowers.models.LigneCommande;

import java.util.List;
import java.util.Optional;

public interface LigneCommandeService {

    LigneCommandeDto saveOrderItem(LigneCommandeDto ligneCommandeDto);

    LigneCommandeDto findOrderItemById(Long id);

    LigneCommandeDto updateOrderItem(Long Id, LigneCommandeDto ligneCommandeDto);

    List<LigneCommandeDto> findAllOrderItems();

    List<LigneCommandeDto> findArticlesGroupByProductId();

    List<LigneCommandeDto> findByOrderByIdDesc();

    List<LigneCommandeDto> ListOrderItemByOrderId(Long comId);

    List<LigneCommandeDto> findTop200ByOrderByIdDesc();

    void deleteOrderItem(Long Id);

}
