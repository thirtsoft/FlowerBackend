package com.flowers.controllers;

import com.flowers.controllers.api.CheckoutApi;
import com.flowers.models.Utilisateur;
import com.flowers.dtos.checkout.Purchase;
import com.flowers.dtos.checkout.PurchaseResponse;
import com.flowers.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CheckoutController implements CheckoutApi {

    private final CheckoutService checkoutService;

    private final UtilisateurService utilisateurService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService,
                              UtilisateurService utilisateurService) {
        this.checkoutService = checkoutService;
        this.utilisateurService = utilisateurService;
    }

    @Override
    public ResponseEntity<PurchaseResponse> purchase(Purchase purchase) {
        PurchaseResponse response = this.checkoutService.placeToOrder(purchase);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PurchaseResponse> purchaseWithUser(Purchase purchase, Long id) {

        Utilisateur utilisateur = utilisateurService.findUtilisateurById(id).get();

        //    Utilisateur utilisateur = Optional.of(utilisateurService.findUtilisateurById(id)).get();


        purchase.setUtilisateur(utilisateur);

        PurchaseResponse response = this.checkoutService.placeToOrderWithUser(purchase);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PurchaseResponse> purchaseWithLoginUser(Purchase purchase, Long id) {

        //     Utilisateur utilisateur = utilisateurService.findUtilisateurById(id).get();

        Utilisateur utilisateur = utilisateurService.findUtilisateurById(id).get();

        //    Utilisateur utilisateur = Optional.of(utilisateurService.findUtilisateurById(id)).get();

        purchase.setUtilisateur(utilisateur);

        PurchaseResponse response = this.checkoutService.placeToOrderWithUser(purchase);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
