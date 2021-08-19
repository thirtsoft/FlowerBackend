package com.flowers.services;

import com.flowers.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAllOrders();

    Order saveOrder(Order order);

    Optional<Order> findOrderById(Long id);

    Order updateOrder(Long Id, Order order);

    void deleteOrder(Long Id);

    Order findByCode(String code);

    Order findByDesignation(String designation);

    List<Order> ListOrderByCode(String designation);

    List<Order> ListOrderByDesignation(String designation);


}
