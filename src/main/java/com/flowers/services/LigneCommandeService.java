package com.flowers.services;

import com.flowers.dtos.LigneCommandeDto;

import java.util.List;

public interface LigneCommandeService {

    LigneCommandeDto findOrderItemById(Long id);

    List<LigneCommandeDto> findAllOrderItems();

    List<LigneCommandeDto> findArticlesGroupByProductId();

    List<LigneCommandeDto> ListOrderItemByOrderId(Long comId);

    List<LigneCommandeDto> findTop200ByOrderByIdDesc();

    List<LigneCommandeDto> findTop8ByOrderByIdDesc();

    List<LigneCommandeDto> findTop3ByOrderByIdDesc();

    List<LigneCommandeDto> findAllActiveLigneCommandes();
}
