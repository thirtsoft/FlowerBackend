package com.flowers.services.Impl;

import com.flowers.models.Client;
import com.flowers.models.Order;
import com.flowers.models.OrderItem;
import com.flowers.models.Utilisateur;
import com.flowers.models.checkout.Purchase;
import com.flowers.models.checkout.PurchaseResponse;
import com.flowers.reposiory.ClientRepository;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.services.CheckoutService;
import com.flowers.services.UtilisateurService;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {

    private final ClientRepository clientRepository;

    private final UtilisateurService utilisateurService;

    private final UtilisateurRepository utilisateurRepository;

    private final String status = "ENCOURS";

    @Autowired
    public CheckoutServiceImpl(ClientRepository clientRepository,
                               UtilisateurService utilisateurService,
                               UtilisateurRepository utilisateurRepository) {
        this.clientRepository = clientRepository;
        this.utilisateurService = utilisateurService;
        this.utilisateurRepository = utilisateurRepository;
    }


    @Override
    public PurchaseResponse placeToOrder(Purchase purchase) {

        System.out.println(purchase);
        // retrieve the order from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        order.setStatus(status);
        order.setOrderDate(new Date());

        // populate order with orderItems
        List<OrderItem> orderItemList = purchase.getOrderItemList();
        orderItemList.forEach(item -> order.add(item));

        // populate order with shippingAddress and billingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Client client = purchase.getClient();
        client.add(order);

        // save customer to database
        clientRepository.save(client);

        // return response
        return new PurchaseResponse(orderTrackingNumber);
    }

    @Override
    public PurchaseResponse placeToOrderWithUser(Purchase purchase) {

        System.out.println(purchase);
        // retrieve the order from dto
        Order order = purchase.getOrder();

        Utilisateur utilisateur = purchase.getUtilisateur();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        Long numeroOrder = generateNumeroCommande();
        order.setOrderTrackingNumber(orderTrackingNumber);
        order.setNumeroOrder(numeroOrder);
        order.setStatus(status);
        order.setOrderDate(new Date());

        // attach loggin user to order
        order.setUtilisateur(utilisateur);

        // populate order with orderItems
        List<OrderItem> orderItemList = purchase.getOrderItemList();
        orderItemList.forEach(item -> order.add(item));

        // populate order with shippingAddress and billingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Client client = purchase.getClient();
        client.add(order);

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
