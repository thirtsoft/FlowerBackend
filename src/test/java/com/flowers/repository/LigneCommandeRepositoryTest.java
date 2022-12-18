package com.flowers.repository;

import com.flowers.models.Commande;
import com.flowers.models.LigneCommande;
import com.flowers.models.Product;
import com.flowers.reposiory.CommandeRepository;
import com.flowers.reposiory.LigneCommandeRepository;
import com.flowers.reposiory.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LigneCommandeRepositoryTest {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommandeRepository commandeRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_ligne_commande_Test() {
        Product product = new Product();
        product.setReference("PROD001");
        product.setDesignation("Product001");
        productRepository.save(product);
        Commande commande = new Commande();
        commande.setNumeroCommande(65412789L);
        commande.setTotalCommande(478563213);
        commandeRepository.save(commande);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(1L);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);
        ligneCommande.setPrice(457812);
        ligneCommande.setQuantity(10);
        ligneCommandeRepository.save(ligneCommande);

        assertThat(ligneCommande.getId()).isGreaterThan(0);
        assertThat(ligneCommande.getProduct()).isEqualTo(product);
        assertThat(ligneCommande.getCommande()).isEqualTo(commande);
    }

    @Test
    @Order(2)
    public void get_and_return_on_ligne_commande_by_Id_Test() {

        Product product = new Product();
        product.setReference("PROD00001");
        product.setDesignation("Product001");
        productRepository.save(product);
        Commande commande = new Commande();
        commande.setNumeroCommande(65412789L);
        commande.setTotalCommande(478563213);
        commandeRepository.save(commande);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(1L);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);
        ligneCommande.setPrice(457812);
        ligneCommande.setQuantity(10);
        ligneCommandeRepository.save(ligneCommande);

        LigneCommande optionalLigneCommande = ligneCommandeRepository.findById(1L).get();

        assertThat(optionalLigneCommande.getId()).isEqualTo(ligneCommande.getId());
        assertThat(optionalLigneCommande.getCommande()).isEqualTo(ligneCommande.getCommande());
        assertThat(optionalLigneCommande.getPrice()).isEqualTo(457812);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_ligne_Commande_by_id_Test() {
        Optional<LigneCommande> optionalLigneCommande = ligneCommandeRepository.findById(1L);
        if (optionalLigneCommande.isPresent()) {
            LigneCommande ligneCommande = optionalLigneCommande.get();
            ligneCommande.setPrice(789456123);

            LigneCommande ligneCommandeUpdated = ligneCommandeRepository.save(ligneCommande);
            assertThat(ligneCommandeUpdated.getId()).isEqualTo(ligneCommande.getId());
            assertThat(ligneCommandeUpdated.getPrice()).isEqualTo(789456123);
        }
    }


    @Test
    @Order(4)
    public void should_and_return_all_ligne_commande_Test() {

        Product product = new Product();
        product.setReference("PROD002");
        product.setDesignation("Product001");
        productRepository.save(product);
        Commande commande = new Commande();
        commande.setNumeroCommande(65412789L);
        commande.setTotalCommande(478563213);
        commandeRepository.save(commande);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(1L);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);
        ligneCommande.setPrice(457812);
        ligneCommande.setQuantity(10);
        ligneCommandeRepository.save(ligneCommande);

        List<LigneCommande> ligneCommandeList = ligneCommandeRepository.findAll();

        assertThat(ligneCommandeList.size()).isNotNull();
        assertThat(ligneCommandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void should_and_return_all_ligne_commandes_by_IdDesc_Test() {

        Product product = new Product();
        product.setReference("PROD003");
        product.setDesignation("Product001");
        productRepository.save(product);
        Commande commande = new Commande();
        commande.setNumeroCommande(65412789L);
        commande.setTotalCommande(478563213);
        commandeRepository.save(commande);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(1L);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduct(product);
        ligneCommande.setPrice(457812);
        ligneCommande.setQuantity(10);
        ligneCommandeRepository.save(ligneCommande);

        List<LigneCommande> ligneCommandeList = ligneCommandeRepository.findByOrderByIdDesc();

        assertThat(ligneCommandeList.size()).isNotNull();
        assertThat(ligneCommandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    public void should_and_return_all_ligne_commandes_by_commande_id_Test() {
        Long idCom = 1L;
        List<LigneCommande> ligneCommandeList = ligneCommandeRepository.ListOrderItemByOrderId(idCom);
        assertThat(ligneCommandeList.size()).isNotNull();
        assertThat(ligneCommandeList.size()).isGreaterThan(0);
    }


    @Test
    @Order(7)
    @Rollback(value = false)
    public void delete_ligne_Commande_by_id_Test() {
        Optional<LigneCommande> optionalLigneCommande = ligneCommandeRepository.findById(1L);
        if (optionalLigneCommande.isPresent()) {
            ligneCommandeRepository.delete(optionalLigneCommande.get());
        }
        LigneCommande ligneCommande = null;
        Optional<LigneCommande> optionalLigneCommande01 = ligneCommandeRepository.findById(1L);
        if (optionalLigneCommande01.isPresent()) {
            ligneCommande = optionalLigneCommande01.get();
        }
        assertThat(ligneCommande).isNull();
    }

}
