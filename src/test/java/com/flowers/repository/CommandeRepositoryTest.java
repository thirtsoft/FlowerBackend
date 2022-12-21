package com.flowers.repository;

import com.flowers.models.*;
import com.flowers.reposiory.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommandeRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void save_commande_Test() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Client01");
        client.setLastName("Client01");
        clientRepository.save(client);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setName("User01");
        utilisateur.setMobile("779440310");
        utilisateurRepository.save(utilisateur);
        Address address = new Address();
        address.setId(1L);
        address.setZipcode("45789");
        address.setCity("Hann-Mariste 2");
        addressRepository.save(address);
        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(1L);
        ligneCommande.setQuantity(1);
        ligneCommande.setPrice(25000);

        List<LigneCommande> ligneCommandeList = new ArrayList<>();
        ligneCommandeList.add(ligneCommande);

        Commande commande = new Commande();
        commande.setId(1L);
        commande.setNumeroCommande(45000L);
        commande.setTotalCommande(500000);
        commande.setStatus("waiting");
        ligneCommandeList.forEach(item -> commande.add(item));
        commande.setClient(client);

        commandeRepository.save(commande);

        assertThat(commande.getId()).isGreaterThan(0);
        assertThat(commande.getNumeroCommande()).isNotNull();
        assertThat(commande.getNumeroCommande()).isEqualTo(45000L);
        assertThat(commande.getTotalCommande()).isGreaterThan(100000);
    }

    @Test
    @Order(2)
    public void get_and_return_on_commande_by_Id_Test() {
        Commande commande = new Commande();
        commande.setId(1L);
        commande.setNumeroCommande(45000L);
        commande.setTotalCommande(500000);
        commande.setStatus("waiting");
        commandeRepository.save(commande);

        Commande optionalCommande = commandeRepository.findById(1L).get();

        assertThat(optionalCommande.getId()).isEqualTo(commande.getId());
        assertThat(optionalCommande.getNumeroCommande()).isEqualTo(commande.getNumeroCommande());
        assertThat(optionalCommande.getTotalCommande()).isEqualTo(500000);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void update_commande_by_id_Test() {
        Optional<Commande> optionalCommande = commandeRepository.findById(1L);
        if (optionalCommande.isPresent()) {
            Commande commande = optionalCommande.get();
            commande.setNumeroCommande(25L);

            Commande commandeUpdated = commandeRepository.save(commande);
            assertThat(commandeUpdated.getId()).isEqualTo(commande.getId());
            assertThat(commandeUpdated.getNumeroCommande()).isEqualTo(25L);
        }
    }

    @Test
    @Order(4)
    public void should_and_return_all_commandes_Test() {
        Commande commande = new Commande();
        commande.setId(1L);
        commande.setNumeroCommande(45000L);
        commande.setTotalCommande(500000);
        commande.setStatus("waiting");
        commandeRepository.save(commande);

        List<Commande> commandeList = commandeRepository.findAll();

        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void should_and_return_all_commandes_by_IdDesc_Test() {
        Commande commande = new Commande();
        commande.setId(1L);
        commande.setNumeroCommande(45000L);
        commande.setTotalCommande(500000);
        commande.setStatus("waiting");
        commandeRepository.save(commande);

        List<Commande> commandeList = commandeRepository.findByOrderByIdDesc();

        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(6)
    public void should_and_return_all_pending_commandes_Test() {
        Commande commande = new Commande();
        commande.setId(1L);
        commande.setNumeroCommande(45000L);
        commande.setTotalCommande(500000);
        commande.setStatus("waiting");
        commandeRepository.save(commande);

        List<Commande> commandeList = commandeRepository.findListOrderByStatusPending();

        assertThat(commandeList.size()).isNotNull();
    }

    @Test
    @Order(7)
    public void should_and_return_all_payed_commandes_Test() {
        Commande commande = new Commande();
        commande.setId(1L);
        commande.setNumeroCommande(45000L);
        commande.setTotalCommande(500000);
        commande.setStatus("waiting");
        commandeRepository.save(commande);

        List<Commande> commandeList = commandeRepository.findListOrderByStatusPayed();

        assertThat(commandeList.size()).isNotNull();
    }

    @Test
    @Order(8)
    public void should_and_return_commandes_by_customer_id_Test() {
        Long customerId = 1L;
        List<Commande> commandeList = commandeRepository.ListOrderByCustomerId(customerId);

        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(9)
    public void should_and_return_commandes_by_address_livraison_Test() {
        Long addId = 1L;
        List<Commande> commandeList = commandeRepository.ListOrderByAddressLivraisonId(addId);

        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(10)
    public void should_and_return_commandes_by_address_achat_Test() {
        Long addId = 1L;
        List<Commande> commandeList = commandeRepository.ListOrderByAddressAchatId(addId);

        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @Order(11)
    public void get_number_Of_commande_Test() {
        BigDecimal number = commandeRepository.countNumberOfOrder();
        BigDecimal val = BigDecimal.valueOf(2000000.45);
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(12)
    public void get_number_Of_commande_in_month_Test() {
        BigDecimal number = commandeRepository.countNumberOfOrdersInMonth();
        BigDecimal val = BigDecimal.valueOf(200000.45);
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(13)
    public void get_sum_Of_commande_in_day_Test() {
        BigDecimal number = commandeRepository.sumTotalOfOrderByDay();
        BigDecimal val = BigDecimal.valueOf(20000000000.45);
        assertThat(number).isNotEqualTo(BigDecimal.ONE.longValue());
    }

    @Test
    @Order(14)
    public void get_sum_Of_commande_in_month_Test() {
        BigDecimal number = commandeRepository.sumTotaleOfOrderByMonth();
        BigDecimal val = BigDecimal.valueOf(20000000000000000.45);
        assertThat(number).isNotEqualTo(BigDecimal.ONE.longValue());
    }

    @Test
    @Order(15)
    public void get_sum_Of_commande_in_year_Test() {
        BigDecimal number = commandeRepository.sumTotalOfOrdersByYear();
        BigDecimal val = BigDecimal.valueOf(20000000000000000.45);
        assertThat(number).isNotEqualTo(BigDecimal.ONE.longValue());
    }

    @Test
    @Order(16)
    public void get_number_Of_pending_commande_Test() {
        BigDecimal number = commandeRepository.countNumberOfOrdersByStatusPending();
        BigDecimal val = BigDecimal.valueOf(20000000000000000.45);
        assertThat(number).isLessThan(val);
    }

    @Test
    @Order(17)
    public void get_number_Of_commande_peer_day_Test() {
        List<?> commandeList = commandeRepository.countNumberOfOrderByDay();
        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(18)
    public void get_number_Of_commande_peer_month_Test() {
        List<?> commandeList = commandeRepository.countNumberOfOrderByMonth();
        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(19)
    public void get_sum_Of_commande_peer_month_Test() {
        List<?> commandeList = commandeRepository.sumTotalOfOrderByMonth();
        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(20)
    public void get_sum_Of_commande_peer_year_Test() {
        List<?> commandeList = commandeRepository.sumTotalOfOrderByYears();
        assertThat(commandeList.size()).isNotNull();
        assertThat(commandeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(21)
    @Rollback(value = false)
    public void delete_client_by_id_Test() {
        Optional<Commande> optionalCommande = commandeRepository.findById(1L);
        if (optionalCommande.isPresent()) {
            commandeRepository.delete(optionalCommande.get());
        }
        Commande commande = null;
        Optional<Commande> optionalCommande01 = commandeRepository.findById(1L);
        if (optionalCommande01.isPresent()) {
            commande = optionalCommande01.get();
        }
        assertThat(commande).isNull();
    }


}
