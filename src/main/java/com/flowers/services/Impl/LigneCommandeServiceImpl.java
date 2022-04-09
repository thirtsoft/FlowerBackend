package com.flowers.services.Impl;

import com.flowers.dtos.LigneCommandeDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.LigneCommande;
import com.flowers.reposiory.LigneCommandeRepository;
import com.flowers.services.LigneCommandeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class LigneCommandeServiceImpl implements LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    public LigneCommandeServiceImpl(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @Override
    public LigneCommandeDto saveOrderItem(LigneCommandeDto ligneCommandeDto) {
        return LigneCommandeDto.fromEntityToDto(
                ligneCommandeRepository.save(
                        LigneCommandeDto.fromDtoToEntity(ligneCommandeDto)
                )
        );
    }

    @Override
    public LigneCommandeDto updateOrderItem(Long Id, LigneCommandeDto ligneCommandeDto) {
        return null;
    }

    @Override
    public LigneCommandeDto findOrderItemById(Long id) {
        if (id == null) {
            log.error("LigneCommande Id is null");
            return null;
        }

        Optional<LigneCommande> ligneCommande = ligneCommandeRepository.findById(id);

        return Optional.of(LigneCommandeDto.fromEntityToDto(ligneCommande.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun LigneCommande avec l'Id = " + id + "n'a été trouvé")
        );
    }


    @Override
    public List<LigneCommandeDto> findAllOrderItems() {
        return ligneCommandeRepository.findAll().stream()
                .map(LigneCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeDto> findArticlesGroupByProductId() {
        return ligneCommandeRepository.findArticlesGroupByProductId().stream()
                .map(LigneCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeDto> findByOrderByIdDesc() {
        return ligneCommandeRepository.findByOrderByIdDesc().stream()
                .map(LigneCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeDto> ListOrderItemByOrderId(Long comId) {
        return ligneCommandeRepository.ListOrderItemByOrderId(comId).stream()
                .map(LigneCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeDto> findTop200ByOrderByIdDesc() {
        return ligneCommandeRepository.findTop200ByOrderByIdDesc().stream()
                .map(LigneCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeDto> findTop8ByOrderByIdDesc() {
        return ligneCommandeRepository.findTop8ByOrderByIdDesc().stream()
                .map(LigneCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeDto> findTop3ByOrderByIdDesc() {
        return ligneCommandeRepository.findTop3ByOrderByIdDesc().stream()
                .map(LigneCommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrderItem(Long Id) {
        if (Id == null) {
            log.error("OrderItem not found");
            return;
        }
        ligneCommandeRepository.deleteById(Id);
    }
}
