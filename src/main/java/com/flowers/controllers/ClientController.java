package com.flowers.controllers;


import com.flowers.controllers.api.ClientApi;
import com.flowers.dtos.AddressDto;
import com.flowers.dtos.ClientDto;
import com.flowers.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Override
    public ResponseEntity<ClientDto> saveClient(ClientDto clientDto) {
        ClientDto clientDtoResult = clientService.save(clientDto);
        return new ResponseEntity<>(clientDtoResult, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClientDto> getClientById(Long id) {
        ClientDto clientDtoResult = clientService.findById(id);
        return new ResponseEntity<>(clientDtoResult, HttpStatus.OK);
    }

    @Override
    public BigDecimal countNumberOfClients() {
        return clientService.countNumberOfClient();
    }

    @Override
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clientDtoList = clientService.findAll();
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientDto>> getAllClientsOrderByIdDesc() {
        List<ClientDto> clientDtoList = clientService.findByOrderByIdDesc();
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        clientService.delete(id);
    }
}
