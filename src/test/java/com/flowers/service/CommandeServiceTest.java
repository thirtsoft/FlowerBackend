package com.flowers.service;


import com.flowers.dtos.ClientDto;
import com.flowers.dtos.CommandeDto;
import com.flowers.models.Address;
import com.flowers.models.Client;
import com.flowers.models.Commande;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.AddressRepository;
import com.flowers.reposiory.ClientRepository;
import com.flowers.reposiory.CommandeRepository;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.services.Impl.CommandeServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CommandeServiceTest {

    @InjectMocks
    private CommandeServiceImpl commandeService;

    @Mock
    private CommandeRepository commandeRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Test
    public void should_find_and_return_one_commande() {
        Commande commande = new Commande();
        commande.setId(2L);
        commande.setNumeroCommande(480000L);
        commande.setTotalCommande(580000);
        commande.setStatus("Valide");
        commande.setDateCommande(new Date());
        when(commandeRepository.findById(anyLong())).thenReturn(Optional.of(commande));

        CommandeDto commandeDtoResult = commandeService.findOrderById(anyLong());

        Commande commandeResult = CommandeDto.fromDtoToEntity(commandeDtoResult);

        assertThat(commandeResult).usingRecursiveComparison().isEqualTo(commande);
        verify(commandeRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(commandeRepository);
    }

    /*
    @Test
    public void should_update_commande() {
        Commande commande = new Commande();
        commande.setId(3L);
        commande.setNumeroCommande(500000L);
        commande.setTotalCommande(590000);
        commande.setStatus("Valide");
        commande.setDateCommande(new Date());

        when(commandeRepository.findById(anyLong())).thenReturn(Optional.of(commande));

        CommandeDto commandeDto = commandeService.findOrderById(CommandeDto.fromEntityToDto(commande.getId()));
        CommandeDto commandeDtoResult = commandeService.saveOrder(commandeDto);

        commandeDtoResult.setNumeroCommande(7500000L);
        CommandeDto commandeDtoUpdated = commandeService.saveOrder(commandeDtoResult);
        commandeService.saveOrder(commandeDtoUpdated);

        Commande commandeResult = CommandeDto.fromDtoToEntity(commandeDtoUpdated);

      //  assertThat(commandeResult.getNumeroCommande()).usingRecursiveComparison().isNotEqualTo(commande.getNumeroCommande());
        assertThat(commandeResult.getNumeroCommande()).isGreaterThanOrEqualTo(20L);

    }

    @Test
    public void should_update_status_of_commande() {
        Commande commande = new Commande();
        commande.setId(4L);
        commande.setNumeroCommande(500L);
        commande.setTotalCommande(5900);
        commande.setStatus("Encours");
        commande.setDateCommande(new Date());

        when(commandeRepository.findById(anyLong())).thenReturn(Optional.of(commande));

        CommandeDto commandeDtoResult = commandeService.findOrderById(anyLong());
        commandeDtoResult.setStatus("VALIDEE");
        commandeService.saveOrder(commandeDtoResult);

        Commande commandeResult = CommandeDto.fromDtoToEntity(commandeDtoResult);

        assertThat(commandeResult).usingRecursiveComparison().isNotEqualTo(commande);
        assertThat(commandeResult.getStatus()).isEqualTo("VALIDEE");

    }


     */

    @Test
    public void should_find_and_return_all_commandes() {
        Commande commande = new Commande();
        commande.setId(5L);
        commande.setNumeroCommande(5L);
        commande.setTotalCommande(59);
        commande.setStatus("Encours");
        commande.setDateCommande(new Date());

        when(commandeRepository.findAll()).thenReturn(singletonList(commande));

        List<CommandeDto> commandeList = commandeService.findAllActiveCommandes();

        assertThat(commandeList).isNotNull();
        assertThat(commandeList).hasSize(1);
        verify(commandeRepository, times(1)).findAll();
        verifyNoMoreInteractions(commandeRepository);
    }

    @Test
    public void should_find_and_return_all_commandes_by_IdDesc() {
        Commande commande = new Commande();
        commande.setId(6L);
        commande.setNumeroCommande(55L);
        commande.setTotalCommande(52);
        commande.setStatus("Encours");
        commande.setDateCommande(new Date());

        when(commandeRepository.findAll()).thenReturn(singletonList(commande));

        List<CommandeDto> commandeList = commandeService.findAllActiveCommandes();

        assertThat(commandeList).hasSize(1);
        verify(commandeRepository, times(1)).findAll();
        verifyNoMoreInteractions(commandeRepository);
    }

    @Test
    public void should_find_and_return_commandes_by_status_pending() {
        Commande commande = new Commande();
        commande.setId(7L);
        commande.setNumeroCommande(505L);
        commande.setTotalCommande(502);
        commande.setStatus("Encours");
        commande.setDateCommande(new Date());

        when(commandeRepository.findListOrderByStatusPending()).thenReturn(singletonList(commande));

        List<CommandeDto> commandeList = commandeService.findListOrderByStatusPending();

        assertThat(commandeList).hasSize(1);
        verify(commandeRepository, times(1)).findListOrderByStatusPending();
        verifyNoMoreInteractions(commandeRepository);
    }

    @Test
    public void should_find_and_return_commandes_by_status_payed() {
        Commande commande = new Commande();
        commande.setId(8L);
        commande.setNumeroCommande(205L);
        commande.setTotalCommande(202);
        commande.setStatus("Encours");
        commande.setDateCommande(new Date());

        when(commandeRepository.findListOrderByStatusPayed()).thenReturn(singletonList(commande));

        List<CommandeDto> commandeList = commandeService.findListOrderByStatusPayed();

        assertThat(commandeList).hasSize(1);
        verify(commandeRepository, times(1)).findListOrderByStatusPayed();
        verifyNoMoreInteractions(commandeRepository);
    }

    @Test
    public void should_find_and_return_commandes_by_customer_id() {
        Long customerId = 1L;
        when(commandeRepository.ListOrderByCustomerId(customerId)).thenReturn(singletonList(any()));

        List<CommandeDto> commandeList = commandeService.findListOrderByCustomerId(customerId);

        assertThat(commandeList.size()).isGreaterThanOrEqualTo(0);
        verify(commandeRepository, times(1)).ListOrderByCustomerId(customerId);
        verifyNoMoreInteractions(commandeRepository);
    }

    @Test
    public void should_find_and_return_commandes_by_address_id() {
        Long customerId = 1L;
        when(commandeRepository.ListOrderByAddressAchatId(customerId)).thenReturn(singletonList(any()));

        List<CommandeDto> commandeList = commandeService.findListOrderByAddressAchatId(customerId);

        assertThat(commandeList.size()).isGreaterThanOrEqualTo(0);
        verify(commandeRepository, times(1)).ListOrderByAddressAchatId(customerId);
        verifyNoMoreInteractions(commandeRepository);
    }


    @Test
    public void should_delete_one_commande() {
        doNothing().when(commandeRepository).deleteById(anyLong());

        commandeService.deleteCommande(anyLong());
        verify(commandeRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(commandeRepository);
    }


}
