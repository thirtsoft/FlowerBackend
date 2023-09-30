package com.flowers.service;


import com.flowers.dtos.LigneCommandeDto;
import com.flowers.models.Commande;
import com.flowers.models.LigneCommande;
import com.flowers.models.Product;
import com.flowers.reposiory.CommandeRepository;
import com.flowers.reposiory.LigneCommandeRepository;
import com.flowers.reposiory.ProductRepository;
import com.flowers.services.Impl.LigneCommandeServiceImpl;
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
public class LigneCommandeServiceTest {

    @InjectMocks
    private LigneCommandeServiceImpl ligneCommandeService;

    @Mock
    private LigneCommandeRepository ligneCommandeRepository;

    @Mock
    private CommandeRepository commandeRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void should_find_and_return_one_ligne_commande() {
        Commande commande = new Commande();
        commande.setNumeroCommande(455L);
        commande.setTotalCommande(4500);
        commande.setStatus("VALIDEE");
        commandeRepository.save(commande);
        Product product = new Product();
        product.setReference("PRODByID");
        product.setDesignation("Product01");
        productRepository.save(product);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(2L);
        ligneCommande.setPrice(4500);
        ligneCommande.setQuantity(2);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);

        when(ligneCommandeRepository.findById(anyLong())).thenReturn(Optional.of(ligneCommande));

        LigneCommandeDto ligneCommandeDtoResult = ligneCommandeService.findOrderItemById(anyLong());

        LigneCommande ligneCommandeResult = LigneCommandeDto.fromDtoToEntity(ligneCommandeDtoResult);

        assertThat(ligneCommandeResult).usingRecursiveComparison().isEqualTo(ligneCommande);
        verify(ligneCommandeRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(ligneCommandeRepository);
    }

    @Test
    public void should_find_and_return_all_ligne_commandes() {
        Commande commande = new Commande();
        commande.setNumeroCommande(4005L);
        commande.setTotalCommande(4050);
        commande.setStatus("ENCOURS");
        commandeRepository.save(commande);
        Product product = new Product();
        product.setReference("PRODAll");
        product.setDesignation("Product001All");
        productRepository.save(product);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(4L);
        ligneCommande.setPrice(400500);
        ligneCommande.setQuantity(6);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);

        when(ligneCommandeRepository.findAll()).thenReturn(singletonList(ligneCommande));

        List<LigneCommandeDto> ligneCommandeList = ligneCommandeService.findAllOrderItems();

        assertThat(ligneCommandeList).isNotNull();
        assertThat(ligneCommandeList).hasSize(1);
        verify(ligneCommandeRepository, times(1)).findAll();
        verifyNoMoreInteractions(ligneCommandeRepository);
    }

    @Test
    public void should_find_and_return_all_ligne_commandes_by_Id_desc() {
        Commande commande = new Commande();
        commande.setNumeroCommande(400005L);
        commande.setTotalCommande(400050);
        commande.setStatus("ENCOURS");
        commandeRepository.save(commande);
        Product product = new Product();
        product.setReference("PRODAllByID");
        product.setDesignation("Product001AllByID");
        productRepository.save(product);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(5L);
        ligneCommande.setPrice(400500);
        ligneCommande.setQuantity(6);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);

        when(ligneCommandeRepository.findAll()).thenReturn(singletonList(ligneCommande));

        List<LigneCommandeDto> ligneCommandeList = ligneCommandeService.findAllActiveLigneCommandes();

        assertThat(ligneCommandeList).isNotNull();
        assertThat(ligneCommandeList).hasSize(1);
        verify(ligneCommandeRepository, times(1)).findAll();
        verifyNoMoreInteractions(ligneCommandeRepository);
    }

    @Test
    public void should_find_and_return_ligne_commandes_groupe_by_product_Id() {
        Commande commande = new Commande();
        commande.setNumeroCommande(4000005L);
        commande.setTotalCommande(4000050);
        commande.setStatus("ENCOURS");
        commandeRepository.save(commande);
        Product product = new Product();
        product.setReference("PRODAllByIDByProduct");
        product.setDesignation("Product001AllByIDByProduct");
        productRepository.save(product);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(6L);
        ligneCommande.setPrice(400500);
        ligneCommande.setQuantity(6);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);

        when(ligneCommandeRepository.findArticlesGroupByProductId()).thenReturn(singletonList(ligneCommande));

        List<LigneCommandeDto> ligneCommandeList = ligneCommandeService.findArticlesGroupByProductId();

        assertThat(ligneCommandeList).isNotNull();
        assertThat(ligneCommandeList).hasSize(1);
        verify(ligneCommandeRepository, times(1)).findArticlesGroupByProductId();
        verifyNoMoreInteractions(ligneCommandeRepository);
    }

    @Test
    public void should_find_and_return_top200_ligne_commandes_order_by_id_desc() {
        Commande commande = new Commande();
        commande.setNumeroCommande(7000005L);
        commande.setTotalCommande(7000050);
        commande.setStatus("ENCOURS");
        commandeRepository.save(commande);
        Product product = new Product();
        product.setReference("PRODTop200");
        product.setDesignation("Product001Top200");
        productRepository.save(product);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(7L);
        ligneCommande.setPrice(400500);
        ligneCommande.setQuantity(6);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);

        when(ligneCommandeRepository.findTop200ByOrderByIdDesc()).thenReturn(singletonList(ligneCommande));

        List<LigneCommandeDto> ligneCommandeList = ligneCommandeService.findTop200ByOrderByIdDesc();

        assertThat(ligneCommandeList).isNotNull();
        assertThat(ligneCommandeList).hasSize(1);
        verify(ligneCommandeRepository, times(1)).findTop200ByOrderByIdDesc();
        verifyNoMoreInteractions(ligneCommandeRepository);
    }

    @Test
    public void should_find_and_return_ligne_commandes_by_commande_id() {
        Long comId = 1L;

        when(ligneCommandeRepository.ListOrderItemByOrderId(comId)).thenReturn(singletonList(any()));

        List<LigneCommandeDto> ligneCommandeList = ligneCommandeService.ListOrderItemByOrderId(comId);

        assertThat(ligneCommandeList.size()).isGreaterThanOrEqualTo(0);
        verify(ligneCommandeRepository, times(1)).ListOrderItemByOrderId(comId);
        verifyNoMoreInteractions(ligneCommandeRepository);
    }

}
