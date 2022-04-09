package com.flowers.services.Impl;

import com.flowers.dtos.HistoriqueCommandeDto;
import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.dtos.checkout.Purchase;
import com.flowers.dtos.checkout.PurchaseResponse;
import com.flowers.models.*;
import com.flowers.reposiory.ClientRepository;
import com.flowers.reposiory.HistoriqueCommandeRepository;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.services.CheckoutService;
import com.flowers.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

    private final ClientRepository clientRepository;

    private final UtilisateurService utilisateurService;

    private final UtilisateurRepository utilisateurRepository;

    private final HistoriqueCommandeRepository historiqueCommandeRepository;

    private final String status = "ENCOURS";

    @Autowired
    public CheckoutServiceImpl(ClientRepository clientRepository,
                               UtilisateurService utilisateurService,
                               UtilisateurRepository utilisateurRepository,
                               HistoriqueCommandeRepository historiqueCommandeRepository) {
        this.clientRepository = clientRepository;
        this.utilisateurService = utilisateurService;
        this.utilisateurRepository = utilisateurRepository;
        this.historiqueCommandeRepository = historiqueCommandeRepository;
    }

    @Override
    public PurchaseResponse placeToOrder(Purchase purchase) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String login = authentication.getName();

        String currentPrincipalName = authentication.getName();

        System.out.println(purchase);
        // retrieve the order from dto
        Commande commande = purchase.getCommande();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        commande.setOrderTrackingNumber(orderTrackingNumber);
        commande.setStatus(status);
        commande.setDateCommande(new Date());

        // populate order with orderItems
        List<LigneCommande> ligneCommandeList = purchase.getLcomms();
        ligneCommandeList.forEach(item -> commande.add(item));

        // populate order with shippingAddress and billingAddress
        commande.setBillingAddress(purchase.getBillingAddress());
    //    commande.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Client client = purchase.getClient();
        client.add(commande);

        // save customer to database
        clientRepository.save(client);

        // return response
        return new PurchaseResponse(orderTrackingNumber);
    }

    @Override
    public PurchaseResponse placeToOrderWithUser(Purchase purchase) {
        System.out.println(purchase);
        // retrieve the order from dto
        Commande commande = purchase.getCommande();

        Utilisateur utilisateur = purchase.getUtilisateur();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        Long numCommande = generateNumeroCommande();
        commande.setOrderTrackingNumber(orderTrackingNumber);
        commande.setNumeroCommande(numCommande);
        commande.setStatus(status);
        commande.setDateCommande(new Date());

        // attach loggin user to order
        commande.setUtilisateur(utilisateur);

        // populate order with orderItems
        List<LigneCommande> ligneCommandeList = purchase.getLcomms();
        ligneCommandeList.forEach(item -> commande.add(item));

        // populate order with shippingAddress and billingAddress
        commande.setBillingAddress(purchase.getBillingAddress());
    //    commande.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Client client = purchase.getClient();
        client.add(commande);

        // save customer to database
        clientRepository.save(client);

        // return response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID (UUID version-4)
        return UUID.randomUUID().toString();
    }

    public long generateNumeroCommande() {
        final String FORMAT = "yyyyMMddHHmmss";
        return Long.parseLong(DateTimeFormat.forPattern(FORMAT).print(LocalDateTime.now()));
    }

}
