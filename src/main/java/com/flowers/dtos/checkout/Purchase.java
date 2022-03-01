package com.flowers.dtos.checkout;

import com.flowers.models.*;
import lombok.Data;

import java.util.List;

@Data
public class Purchase {
    private Client client;
    private Utilisateur utilisateur;
    private Address shippingAddress;
    private Address billingAddress;
    private Commande commande;
    private List<LigneCommande> lcomms;
}
