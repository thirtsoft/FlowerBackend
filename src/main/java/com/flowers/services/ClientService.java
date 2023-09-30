package com.flowers.services;

import com.flowers.dtos.ClientDto;

import java.math.BigDecimal;
import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto clientDto);

    ClientDto update(Long id, ClientDto clientDto);

    BigDecimal countNumberOfClient();

    ClientDto findById(Long id);

    List<ClientDto> findAll();

    List<ClientDto> findByOrderByIdDesc();

    List<ClientDto> findAllActiveClients();

    void deleteClient(Long clientId);
}
