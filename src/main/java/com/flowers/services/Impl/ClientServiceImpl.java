package com.flowers.services.Impl;

import com.flowers.dtos.ClientDto;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Client;
import com.flowers.reposiory.ClientRepository;
import com.flowers.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        clientDto.setActif(true);
        return ClientDto.fromEntityToDto(
                clientRepository.save(
                        ClientDto.fromDtoToEntity(clientDto)
                )
        );
    }

    @Override
    public ClientDto update(Long id, ClientDto clientDto) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found");
        }

        Optional<Client> optionalClient = clientRepository.findById(id);

        if (!optionalClient.isPresent()) {
            throw new ResourceNotFoundException("Client not found");
        }

        ClientDto clientDtoResult = ClientDto.fromEntityToDto(optionalClient.get());

        clientDtoResult.setFirstName(clientDto.getFirstName());
        clientDtoResult.setLastName(clientDto.getLastName());
        clientDtoResult.setMobile(clientDto.getMobile());
        clientDtoResult.setEmail(clientDto.getEmail());

        return ClientDto.fromEntityToDto(
                clientRepository.save(
                        ClientDto.fromDtoToEntity(clientDtoResult)
                )
        );
    }

    @Override
    public BigDecimal countNumberOfClient() {
        return clientRepository.countNumberOfClient();
    }

    @Override
    public ClientDto findById(Long id) {
        if (id == null) {
            log.error("Client Id is null");
            return null;
        }

        Optional<Client> optionalClient = clientRepository.findById(id);

        return Optional.of(ClientDto.fromEntityToDto(optionalClient.get())).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Aucnun Client avec l'Id = " + id + "n'a été trouvé")
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> findByOrderByIdDesc() {
        return clientRepository.findByOrderByIdDesc().stream()
                .map(ClientDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> findAllActiveClients() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClient(Long clientId) {
        if (clientId == null) {
            log.error("Client Id is null");
        }
        Client client = clientRepository.findById(clientId).get();
        client.setActif(false);
        clientRepository.save(client);
    }
}
