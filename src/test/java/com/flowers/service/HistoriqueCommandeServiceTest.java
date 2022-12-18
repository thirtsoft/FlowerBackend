package com.flowers.service;


import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.models.Commande;
import com.flowers.models.HistoriqueCommande;
import com.flowers.reposiory.CommandeRepository;
import com.flowers.reposiory.HistoriqueCommandeRepository;
import com.flowers.services.Impl.HistoriqueCommandeServiceImpl;
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
public class HistoriqueCommandeServiceTest {

    @InjectMocks
    private HistoriqueCommandeServiceImpl historiqueCommandeService;

    @Mock
    private HistoriqueCommandeRepository historiqueCommandeRepository;

    @Mock
    private CommandeRepository commandeRepository;

    @Test
    public void should_save_one_historique_commande() {
        Commande commande = new Commande();
        commande.setNumeroCommande(500000L);
        commande.setTotalCommande(5000000);
        commande.setStatus("VALIDE");
        commande.setDateCommande(new Date());
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(1L);
        historiqueCommande.setAction("AJOUT COMMANDE");
        historiqueCommande.setCommande(commande);
        historiqueCommande.setCreatedDate(new Date());

        when(historiqueCommandeRepository.save(any(HistoriqueCommande.class))).thenReturn(historiqueCommande);

        HistoriqueCommandeDto historiqueCommandeDto = historiqueCommandeService.saveHistoriqueCommande(HistoriqueCommandeDto.fromEntityToDto(new HistoriqueCommande()));

        HistoriqueCommande historiqueCommandeResult = HistoriqueCommandeDto.fromDtoToEntity(historiqueCommandeDto);

        assertThat(historiqueCommandeResult).usingRecursiveComparison().isEqualTo(historiqueCommande);
        verify(historiqueCommandeRepository, times(1)).save(any(HistoriqueCommande.class));
        verifyNoMoreInteractions(historiqueCommandeRepository);
    }

    @Test
    public void should_find_and_return_one_HistoriqueCommande() {
        Commande commande = new Commande();
        commande.setNumeroCommande(50000L);
        commande.setTotalCommande(500000);
        commande.setStatus("VALIDE");
        commande.setDateCommande(new Date());
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(2L);
        historiqueCommande.setAction("AJOUT COMMANDE");
        historiqueCommande.setCommande(commande);
        historiqueCommande.setCreatedDate(new Date());

        when(historiqueCommandeRepository.findById(anyLong())).thenReturn(Optional.of(historiqueCommande));

        HistoriqueCommandeDto historiqueCommandeDtoResult = historiqueCommandeService.findHistoriqueCommandeById(anyLong());

        HistoriqueCommande historiqueCommandeResult = HistoriqueCommandeDto.fromDtoToEntity(historiqueCommandeDtoResult);

        assertThat(historiqueCommandeResult).usingRecursiveComparison().isEqualTo(historiqueCommande);
        verify(historiqueCommandeRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(historiqueCommandeRepository);
    }

    @Test
    public void should_update_historiqueCommande() {
        Commande commande = new Commande();
        commande.setNumeroCommande(5000L);
        commande.setTotalCommande(5000);
        commande.setStatus("VALIDE");
        commande.setDateCommande(new Date());
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(3L);
        historiqueCommande.setAction("AJOUT COMMANDE");
        historiqueCommande.setCommande(commande);
        historiqueCommande.setCreatedDate(new Date());

        when(historiqueCommandeRepository.findById(anyLong())).thenReturn(Optional.of(historiqueCommande));

        HistoriqueCommandeDto historiqueCommandeDtoResult = historiqueCommandeService.findHistoriqueCommandeById(anyLong());
        historiqueCommandeDtoResult.setAction("HistoriqueCommande002");
        historiqueCommandeService.saveHistoriqueCommande(historiqueCommandeDtoResult);

        HistoriqueCommande historiqueCommandeResult = HistoriqueCommandeDto.fromDtoToEntity(historiqueCommandeDtoResult);

        assertThat(historiqueCommandeResult).usingRecursiveComparison().isNotEqualTo(historiqueCommande);
        assertThat(historiqueCommandeResult.getAction()).isEqualTo("HistoriqueCommande002");

    }


    @Test
    public void should_find_and_return_all_historiqueCommandes() {
        Commande commande = new Commande();
        commande.setNumeroCommande(5000L);
        commande.setTotalCommande(5000);
        commande.setStatus("VALIDE");
        commande.setDateCommande(new Date());
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(4L);
        historiqueCommande.setAction("AJOUT COMMANDE");
        historiqueCommande.setCommande(commande);
        historiqueCommande.setCreatedDate(new Date());

        when(historiqueCommandeRepository.findAll()).thenReturn(singletonList(historiqueCommande));

        List<HistoriqueCommandeDto> historiqueCommandeList = historiqueCommandeService.findAllHistoriqueCommandes();

        assertThat(historiqueCommandeList).isNotNull();
        assertThat(historiqueCommandeList).hasSize(1);
        verify(historiqueCommandeRepository, times(1)).findAll();
        verifyNoMoreInteractions(historiqueCommandeRepository);
    }

    @Test
    public void should_find_and_return_all_historiqueCommande_by_Id_desc() {
        Commande commande = new Commande();
        commande.setNumeroCommande(5000L);
        commande.setTotalCommande(5000);
        commande.setStatus("VALIDE");
        commande.setDateCommande(new Date());
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(5L);
        historiqueCommande.setAction("AJOUT COMMANDE");
        historiqueCommande.setCommande(commande);
        historiqueCommande.setCreatedDate(new Date());

        when(historiqueCommandeRepository.findByOrderByIdDesc()).thenReturn(singletonList(historiqueCommande));

        List<HistoriqueCommandeDto> historiqueCommandeList = historiqueCommandeService.findAllHistoriqueCommandeOrderDesc();

        assertThat(historiqueCommandeList).isNotNull();
        assertThat(historiqueCommandeList).hasSize(1);
        verify(historiqueCommandeRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(historiqueCommandeRepository);

    }

    @Test
    public void should_delete_one_historiqueCommande() {
        doNothing().when(historiqueCommandeRepository).deleteById(anyLong());

        historiqueCommandeService.deleteHistoriqueCommande(anyLong());
        verify(historiqueCommandeRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(historiqueCommandeRepository);
    }


}
