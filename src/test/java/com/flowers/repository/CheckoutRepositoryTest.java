package com.flowers.repository;

import com.flowers.models.*;
import com.flowers.reposiory.*;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CheckoutRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void place_item_to_order_Test() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setName("Tairou");
        utilisateurRepository.save(utilisateur);

        Address address = new Address();
        address.setId(1L);
        address.setCity("Mariste 2");
        addressRepository.save(address);

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId(1L);
        ligneCommande.setQuantity(1);
        ligneCommande.setPrice(25000);

        // generate tracking number
        Commande commande = new Commande();
        String orderTrackingNumber = generateOrderTrackingNumber();
        Long numCommande = generateNumeroCommande();
        commande.setOrderTrackingNumber(orderTrackingNumber);
        commande.setNumeroCommande(numCommande);
        commande.setTotalCommande(50000);
        commande.setStatus("ENCOURS");
        commande.setDateCommande(new Date());

        commande.setUtilisateur(utilisateur);

        List<LigneCommande> ligneCommandeList = new ArrayList<>();
        ligneCommandeList.add(ligneCommande);
        ligneCommandeList.forEach(item -> commande.add(item));

        commande.setBillingAddress(address);

        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Tairou");
        client.setLastName("Diallo");
        client.add(commande);

        clientRepository.save(client);

        assertThat(client.getId()).isNotNull();
        assertThat(client.getFirstName()).isEqualTo("Tairou");
        assertThat(commande.getNumeroCommande()).isEqualTo(numCommande);
        assertThat(commande.getTotalCommande()).isEqualTo(50000);

    }


    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }

    public long generateNumeroCommande() {
        final String FORMAT = "yyyyMMddHHmmss";
        return Long.parseLong(DateTimeFormat.forPattern(FORMAT).print(LocalDateTime.now()));
    }

}
