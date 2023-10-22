package com.flowers.services.Impl;

import com.flowers.dtos.checkout.Purchase;
import com.flowers.dtos.checkout.PurchaseResponse;
import com.flowers.enums.Statuscommande;
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
        String orderTrackingNumber = generateOrderTrackingNumber();
        Commande commande = purchase.getCommande();
        commande.setOrderTrackingNumber(orderTrackingNumber);
     //   commande.setStatus(status);
        commande.setStatus(String.valueOf(Statuscommande.ENCOURS));
        commande.setDateCommande(new Date());
        commande.setActif(true);
        // populate order with orderItems
        List<LigneCommande> ligneCommandeList = purchase.getLcomms();
        // ligneCommandeList.forEach(item -> commande.add(item));
        if (ligneCommandeList != null) {
            ligneCommandeList.forEach(ligCmdClt -> {
                ligCmdClt.setActif(true);
                commande.add(ligCmdClt);
            });
        }
        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setCommande(commande);
        historiqueCommande.setAction("Commande Ajoutée");
        historiqueCommande.setCreatedDate(new Date());
        historiqueCommande.setActif(true);
        historiqueCommandeRepository.save(historiqueCommande);

        Address addressLivraison = purchase.getShippingAddress();
        Address addressLivraison02 = purchase.getBillingAddress();
        if (addressLivraison != addressLivraison02) {
            commande.setShippingAddress(addressLivraison);
            addressLivraison.setActif(true);
            addressLivraison.setIsBillingAddress(0);
            commande.setBillingAddress(addressLivraison02);
            addressLivraison02.setActif(true);
            addressLivraison02.setIsBillingAddress(1);
        }else {
            commande.setShippingAddress(addressLivraison);
            addressLivraison.setActif(true);
            addressLivraison.setIsBillingAddress(0);
            commande.setBillingAddress(null);
        }
        // populate customer with order
        Client client = purchase.getClient();
        client.setActif(true);
        client.add(commande);
        clientRepository.save(client);
        return new PurchaseResponse(orderTrackingNumber);
    }

    @Override
    public PurchaseResponse placeToOrderWithUser(Purchase purchase) {
        System.out.println(purchase);
        // retrieve the order from dto
        Commande commande = purchase.getCommande();
        Utilisateur utilisateur = purchase.getUtilisateur();
        String orderTrackingNumber = generateOrderTrackingNumber();
        Long numCommande = generateNumeroCommande();
        commande.setOrderTrackingNumber(orderTrackingNumber);
        commande.setNumeroCommande(numCommande);
        commande.setStatus(status);
        commande.setMontantLivraison(0);
        commande.setDateCommande(new Date());
        commande.setActif(true);

        // attach loggin user to order
        commande.setUtilisateur(utilisateur);

        // populate order with orderItems
        List<LigneCommande> ligneCommandeList = purchase.getLcomms();
        if (ligneCommandeList != null) {
            ligneCommandeList.forEach(ligCmdClt -> {
                ligCmdClt.setActif(true);
                commande.add(ligCmdClt);
            });
        }

        HistoriqueCommande historiqueCommande = new HistoriqueCommande();
        historiqueCommande.setCommande(commande);
        historiqueCommande.setAction("Commande Ajoutée");
        historiqueCommande.setCreatedDate(new Date());
        historiqueCommande.setActif(true);
        historiqueCommandeRepository.save(historiqueCommande);

        // populate order with shippingAddress and billingAddress
        // populate order with shippingAddress and billingAddress
        Address addressLivraison = purchase.getShippingAddress();
        Address addressLivraison02 = purchase.getBillingAddress();
        if (addressLivraison != addressLivraison02) {
            commande.setShippingAddress(addressLivraison);
            addressLivraison.setActif(true);
            addressLivraison.setIsBillingAddress(0);
            commande.setBillingAddress(addressLivraison02);
            addressLivraison02.setActif(true);
            addressLivraison02.setIsBillingAddress(1);
        }else {
            commande.setShippingAddress(addressLivraison);
            addressLivraison.setActif(true);
            addressLivraison.setIsBillingAddress(0);
            commande.setBillingAddress(null);
        }

        // populate customer with order
        Client client = purchase.getClient();
        client.setActif(true);
        client.add(commande);
        clientRepository.save(client);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }

    public long generateNumeroCommande() {
        final String FORMAT = "yyyyMMddHHmmss";
        return Long.parseLong(DateTimeFormat.forPattern(FORMAT).print(LocalDateTime.now()));
    }
}