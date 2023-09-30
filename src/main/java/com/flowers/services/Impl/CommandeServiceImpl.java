package com.flowers.services.Impl;

import com.flowers.dtos.CommandeDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Commande;
import com.flowers.models.HistoriqueCommande;
import com.flowers.models.LigneCommande;
import com.flowers.reposiory.CommandeRepository;
import com.flowers.reposiory.HistoriqueCommandeRepository;
import com.flowers.reposiory.LigneCommandeRepository;
import com.flowers.services.CommandeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;

    private final LigneCommandeRepository ligneCommandeRepository;

    private final HistoriqueCommandeRepository historiqueCommandeRepository;

    private final String status = "ENCOURS";

    double total = 0;

    Logger logger = LoggerFactory.getLogger(CommandeServiceImpl.class);

    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository,
                               LigneCommandeRepository ligneCommandeRepository, HistoriqueCommandeRepository historiqueCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.historiqueCommandeRepository = historiqueCommandeRepository;
    }

    @Override
    public CommandeDto updateStatusOfOrder(String status, String id) {
        Optional<Commande> commandeOptional = commandeRepository.findById(Long.valueOf(id));
        CommandeDto commandeDtoResult = CommandeDto.fromEntityToDto(commandeOptional.get());
        commandeDtoResult.setStatus(status);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setCommande(CommandeDto.fromDtoToEntity(commandeDtoResult));
        historiqueCommande.setAction("MODIFICATION STATUS COMMANDE");
        historiqueCommande.setCreatedDate(new Date());
        historiqueCommandeRepository.save(historiqueCommande);
        return CommandeDto.fromEntityToDto(
                commandeRepository.save(
                        CommandeDto.fromDtoToEntity(commandeDtoResult)
                )
        );
    }

    @Override
    public CommandeDto findOrderById(Long id) {
        if (id == null) {
            log.error("Commande Id is null");
            return null;
        }
        Optional<Commande> commande = commandeRepository.findById(id);
        return Optional.of(CommandeDto.fromEntityToDto(commande.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Commande avec l'Id = " + id + "n'a été trouvé")
        );
    }

    @Override
    public List<CommandeDto> findListOrderByStatusPending() {
        return commandeRepository.findListOrderByStatusPending().stream()
                .map(CommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeDto> findListOrderByStatusPayed() {
        return commandeRepository.findListOrderByStatusPayed().stream()
                .map(CommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeDto> findListOrderByCustomerId(Long userId) {
        return commandeRepository.ListOrderByCustomerId(userId).stream()
                .map(CommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeDto> findListOrderByAddressLivraisonId(Long addLivraison) {
        return commandeRepository.ListOrderByAddressLivraisonId(addLivraison).stream()
                .map(CommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeDto> findListOrderByAddressAchatId(Long addAchat) {
        return commandeRepository.ListOrderByAddressAchatId(addAchat).stream()
                .map(CommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal countNumberOfOrder() {
        return commandeRepository.countNumberOfOrder();
    }

    @Override
    public BigDecimal countNumberOfOrdersInMonth() {
        return commandeRepository.countNumberOfOrdersInMonth();
    }

    @Override
    public BigDecimal sumTotalOfOrderByDay() {
        return commandeRepository.sumTotalOfOrderByDay();
    }

    @Override
    public BigDecimal sumTotaleOfOrderByMonth() {
        return commandeRepository.sumTotaleOfOrderByMonth();
    }

    @Override
    public BigDecimal countNumberOfOrdersByStatusPending() {
        return commandeRepository.countNumberOfOrdersByStatusPending();
    }

    @Override
    public BigDecimal sumTotalOfOrdersByYear() {
        return commandeRepository.sumTotalOfOrdersByYear();
    }

    @Override
    public List<?> countNumberOfOrderByDay() {
        return commandeRepository.countNumberOfOrderByDay();
    }

    @Override
    public List<?> countNumberTotalOfOrderByMonth() {
        return commandeRepository.countNumberOfOrderByMonth();
    }

    @Override
    public List<?> sumTotalOfOrderByMonth() {
        return commandeRepository.sumTotalOfOrderByMonth();
    }

    @Override
    public List<?> sumTotalOfOrdersByYears() {
        return commandeRepository.sumTotalOfOrderByYears();
    }

    @Override
    public Page<CommandeDto> findCommandeByUtilisateurPageables(Long userId, Pageable pageable) {
        return commandeRepository.findOrderByUtilisateurPageables(userId, pageable)
                .map(CommandeDto::fromEntityToDto);
    }

    @Override
    public List<CommandeDto> findAllActiveCommandes() {
        return commandeRepository.findAll().stream()
                .map(CommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCommande(Long comId) {
        if (comId == null) {
            log.error("Commande Id is null");
        }
        Commande commande = commandeRepository.findById(comId).get();
        commande.setActif(false);
        List<LigneCommande> ligneCommandeList = commande.getLcomms();
        if (ligneCommandeList != null) {
            ligneCommandeList.forEach(ligCmdClt -> {
                ligCmdClt.setActif(false);
                ligneCommandeRepository.save(ligCmdClt);
            });
        }
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setCommande(commande);
        historiqueCommande.setAction("SUPPRESSION COMMANDE");
        historiqueCommande.setCreatedDate(new Date());
        historiqueCommandeRepository.save(historiqueCommande);
        commandeRepository.save(commande);

    }
}
