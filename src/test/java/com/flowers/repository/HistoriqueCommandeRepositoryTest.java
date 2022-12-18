package com.flowers.repository;

import com.flowers.models.Commande;
import com.flowers.models.HistoriqueCommande;
import com.flowers.reposiory.CommandeRepository;
import com.flowers.reposiory.HistoriqueCommandeRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HistoriqueCommandeRepositoryTest {

    @Autowired
    private HistoriqueCommandeRepository historiqueCommandeRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_historiqueCommande_Test() {
        Commande commande = new Commande();
        commande.setNumeroCommande(4526317L);
        commande.setTotalCommande(550000000);
        commande.setStatus("VALIDEE");
        commande.setTotalQuantity(12);
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(1L);
        historiqueCommande.setCommande(commande);
        historiqueCommande.setAction("AJOUT COMMANDE");
        historiqueCommande.setCreatedDate(new Date());
        historiqueCommandeRepository.save(historiqueCommande);

        assertThat(historiqueCommande.getId()).isGreaterThan(0);
        assertThat(historiqueCommande.getAction()).isEqualTo("AJOUT COMMANDE");
        assertThat(historiqueCommande.getCommande()).isEqualTo(commande);
    }

    @Test
    @Order(2)
    public void get_and_return_on_historiqueCommande_by_Id_Test() {
        Commande commande = new Commande();
        commande.setNumeroCommande(4526317L);
        commande.setTotalCommande(550000000);
        commande.setStatus("VALIDEE");
        commande.setTotalQuantity(12);
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(1L);
        historiqueCommande.setCommande(commande);
        historiqueCommande.setAction("RECHERCHER COMMANDE");
        historiqueCommande.setCreatedDate(new Date());
        historiqueCommandeRepository.save(historiqueCommande);

        HistoriqueCommande optionalHistoriqueCommande = historiqueCommandeRepository.findById(1L).get();

        assertThat(optionalHistoriqueCommande.getId()).isEqualTo(historiqueCommande.getId());
        assertThat(optionalHistoriqueCommande.getCommande()).isEqualTo(historiqueCommande.getCommande());
        assertThat(optionalHistoriqueCommande.getAction()).isEqualTo("RECHERCHER COMMANDE");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_historiqueCommande_by_id_Test() {
        Optional<HistoriqueCommande> optionalHistoriqueCommande = historiqueCommandeRepository.findById(1L);
        if (optionalHistoriqueCommande.isPresent()) {
            HistoriqueCommande historiqueCommande = optionalHistoriqueCommande.get();
            historiqueCommande.setAction("SUPP COM");

            HistoriqueCommande historiqueCommandeUpdated = historiqueCommandeRepository.save(historiqueCommande);
            assertThat(historiqueCommandeUpdated.getId()).isEqualTo(historiqueCommande.getId());
            assertThat(historiqueCommande.getAction()).isEqualTo("SUPP COM");
        }
    }

    @Test
    @Order(4)
    public void get_number_Of_historiqueCommande_Test() {
        BigDecimal number = historiqueCommandeRepository.countNumberOfHistoriqueCommandes();
        BigDecimal val = BigDecimal.valueOf(200);
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(5)
    public void should_and_return_all_historiqueCommandes_Test() {
        Commande commande = new Commande();
        commande.setNumeroCommande(4526317L);
        commande.setTotalCommande(550000000);
        commande.setStatus("VALIDEE");
        commande.setTotalQuantity(12);
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(1L);
        historiqueCommande.setCommande(commande);
        historiqueCommande.setAction("RECHERCHER COMMANDE");
        historiqueCommande.setCreatedDate(new Date());
        historiqueCommandeRepository.save(historiqueCommande);


        List<HistoriqueCommande> historiqueCommandeList = historiqueCommandeRepository.findAll();

        assertThat(historiqueCommandeList.size()).isNotNull();
        assertThat(historiqueCommandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    public void should_and_return_all_historiqueCommandes_by_IdDesc_Test() {

        Commande commande = new Commande();
        commande.setNumeroCommande(4526317L);
        commande.setTotalCommande(550000000);
        commande.setStatus("VALIDEE");
        commande.setTotalQuantity(12);
        commandeRepository.save(commande);
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setId(1L);
        historiqueCommande.setCommande(commande);
        historiqueCommande.setAction("RECHERCHER COMMANDE");
        historiqueCommande.setCreatedDate(new Date());
        historiqueCommandeRepository.save(historiqueCommande);


        List<HistoriqueCommande> historiqueCommandeList = historiqueCommandeRepository.findByOrderByIdDesc();

        assertThat(historiqueCommandeList.size()).isNotNull();
        assertThat(historiqueCommandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(7)
    @Rollback(value = false)
    public void delete_HistoriqueCommande_by_id_Test() {
        Optional<HistoriqueCommande> optionalHistoriqueCommande = historiqueCommandeRepository.findById(1L);
        if (optionalHistoriqueCommande.isPresent()) {
            historiqueCommandeRepository.delete(optionalHistoriqueCommande.get());
        }
        HistoriqueCommande historiqueCommande = null;
        Optional<HistoriqueCommande> optionalHistoriqueCommande01 = historiqueCommandeRepository.findById(1L);
        if (optionalHistoriqueCommande01.isPresent()) {
            historiqueCommande = optionalHistoriqueCommande01.get();
        }
        assertThat(historiqueCommande).isNull();
    }

}
