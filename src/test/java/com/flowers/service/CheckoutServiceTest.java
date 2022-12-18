package com.flowers.service;


import com.flowers.dtos.ClientDto;
import com.flowers.models.Client;
import com.flowers.reposiory.ClientRepository;
import com.flowers.services.Impl.ClientServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CheckoutServiceTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    public void should_save_one_client() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Tairou");
        client.setLastName("Diallo");
        client.setEmail("thirdiallo@gmail.com");
        client.setMobile("779440310");

        when(clientRepository.save(any(Client.class))).thenReturn(client);

        ClientDto clientDto = clientService.save(ClientDto.fromEntityToDto(new Client()));

        Client clientResult = ClientDto.fromDtoToEntity(clientDto);

        assertThat(clientResult).usingRecursiveComparison().isEqualTo(client);
        verify(clientRepository, times(1)).save(any(Client.class));
        verifyNoMoreInteractions(clientRepository);
    }

    @Test
    public void should_find_and_return_one_client() {
        Client client = new Client();
        client.setId(2L);
        client.setFirstName("TairouById");
        client.setLastName("DialloById");
        client.setEmail("thirdialloById@gmail.com");
        client.setMobile("7794840310");

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(client));

        ClientDto clientDtoResult = clientService.findById(anyLong());

        Client clientResult = ClientDto.fromDtoToEntity(clientDtoResult);

        assertThat(clientResult).usingRecursiveComparison().isEqualTo(client);
        verify(clientRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(clientRepository);
    }

    @Test
    public void should_update_client() {
        Client client = new Client();
        client.setId(3L);
        client.setFirstName("TairouById");
        client.setLastName("DialloById");
        client.setEmail("thirdialloById@gmail.com");
        client.setMobile("7794840310");

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(client));

        ClientDto clientDtoResult = clientService.findById(anyLong());
        clientDtoResult.setFirstName("Client002");
        clientService.save(clientDtoResult);

        Client clientResult = ClientDto.fromDtoToEntity(clientDtoResult);

        assertThat(clientResult).usingRecursiveComparison().isNotEqualTo(client);
        assertThat(clientResult.getFirstName()).isEqualTo("Client002");

    }


    @Test
    public void should_find_and_return_all_clients() {
        Client client = new Client();
        client.setId(4L);
        client.setFirstName("TairouAll");
        client.setLastName("DialloAll");
        client.setEmail("thirdialloAlld@gmail.com");
        client.setMobile("779484031098");

        when(clientRepository.findAll()).thenReturn(singletonList(client));

        List<ClientDto> clientList = clientService.findAll();

        assertThat(clientList).isNotNull();
        assertThat(clientList).hasSize(1);
        verify(clientRepository, times(1)).findAll();
        verifyNoMoreInteractions(clientRepository);
    }

    @Test
    public void should_find_and_return_all_clients_by_IdDesc() {
        Client client = new Client();
        client.setId(5L);
        client.setFirstName("TairouAllById");
        client.setLastName("DialloAllById");
        client.setEmail("thirdialloAllByIdd@gmail.com");
        client.setMobile("779484031258098");

        when(clientRepository.findByOrderByIdDesc()).thenReturn(singletonList(client));

        List<ClientDto> clientList = clientService.findByOrderByIdDesc();

        assertThat(clientList).hasSize(1);
        verify(clientRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(clientRepository);
    }

    @Test
    public void should_delete_one_client() {
        doNothing().when(clientRepository).deleteById(anyLong());

        clientService.delete(anyLong());
        verify(clientRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(clientRepository);
    }


}
