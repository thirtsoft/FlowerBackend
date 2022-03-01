package com.flowers.services.Impl;

import com.flowers.dtos.CommandeDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Commande;
import com.flowers.reposiory.*;
import com.flowers.services.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;

    private final String status = "ENCOURS";

    double total = 0;

    Logger logger = LoggerFactory.getLogger(CommandeServiceImpl.class);

    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository
    ) {
        this.commandeRepository = commandeRepository;
    }


    @Override
    public CommandeDto saveOrder(CommandeDto commandeDto) {
        System.out.println("Initial Numero Commande " + commandeDto.getNumeroCommande());
        logger.info("CommandeDto {}", commandeDto);

        Commande savedCmdClt = commandeRepository.save(CommandeDto.fromDtoToEntity(commandeDto));

        savedCmdClt.setTotalCommande(total);
        savedCmdClt.setStatus(status);
        savedCmdClt.setDateCommande(new Date());

        return CommandeDto.fromEntityToDto(savedCmdClt);

    }

    @Override
    public CommandeDto updateOrder(Long Id, CommandeDto commandeDto) {
        if (!commandeRepository.existsById(Id)) {
            throw new ResourceNotFoundException("Commande not found");
        }

        Optional<Commande> commandeOptional = commandeRepository.findById(Id);

        if (!commandeOptional.isPresent()) {
            throw new ResourceNotFoundException("Commande not found");
        }

        CommandeDto commandeDtoResult = CommandeDto.fromEntityToDto(commandeOptional.get());
        commandeDtoResult.setNumeroCommande(commandeDto.getNumeroCommande());
        commandeDtoResult.setTotalQuantity(commandeDto.getTotalQuantity());
        commandeDtoResult.setTotalQuantity(commandeDto.getTotalQuantity());
        commandeDtoResult.setTotalCommande(commandeDto.getTotalCommande());
        commandeDtoResult.setOrderTrackingNumber(commandeDto.getOrderTrackingNumber());
        commandeDtoResult.setSessionId(commandeDto.getSessionId());
        commandeDtoResult.setStatus(commandeDto.getStatus());
        commandeDtoResult.setClientDto(commandeDto.getClientDto());
        commandeDtoResult.setBillingAddressDto(commandeDto.getBillingAddressDto());
        commandeDtoResult.setDateCommande(commandeDto.getDateCommande());

        return CommandeDto.fromEntityToDto(
                commandeRepository.save(
                        CommandeDto.fromDtoToEntity(commandeDtoResult)
                )
        );
    }

    @Override
    public CommandeDto updateStatusOfOrder(String status, String id) {
        Optional<Commande> commandeOptional = commandeRepository.findById(Long.valueOf(id));

        CommandeDto commandeDtoResult = CommandeDto.fromEntityToDto(commandeOptional.get());

        commandeDtoResult.setStatus(status);

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
    public List<CommandeDto> findAllOrders() {
        return commandeRepository.findAll().stream()
                .map(CommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeDto> findByOrderByIdDesc() {
        return commandeRepository.findByOrderByIdDesc().stream()
                .map(CommandeDto::fromEntityToDto)
                .collect(Collectors.toList());
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
    public void deleteOrder(Long Id) {
        if (Id == null) {
            log.error("Commande Id is null");
            return;
        }
        commandeRepository.deleteById(Id);

    }
}
