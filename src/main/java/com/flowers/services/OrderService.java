package com.flowers.services;

import com.flowers.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order saveOrder(Order order);

    Order updateOrder(Long Id, Order order);

    Order updateStatusOfOrder(String status, String id);

    Optional<Order> findOrderById(Long id);

    List<Order> findAllOrders();

    List<Order> findByOrderByIdDesc();

    List<Order> findListOrderByStatusPending();

    List<Order> findListOrderByStatusPayed();

    List<Order> findListOrderByCustomerId(Long userId);

    List<Order> findListOrderByAddressLivraisonId(Long addLivraison);

    List<Order> findListOrderByAddressAchatId(Long addAchat);

    void deleteOrder(Long Id);


}
