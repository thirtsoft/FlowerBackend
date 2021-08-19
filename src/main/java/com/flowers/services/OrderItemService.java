package com.flowers.services;

import com.flowers.models.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {

    List<OrderItem> findAllOrderItems();

    OrderItem saveOrderItem(OrderItem orderItem);

    Optional<OrderItem> findOrderItemById(Long id);

    OrderItem updateOrderItem(Long Id, OrderItem orderItem);

    void deleteOrderItem(Long Id);

    OrderItem findByCode(String code);

    OrderItem findByDesignation(String designation);

    List<OrderItem> ListOrderItemByCode(String designation);

    List<OrderItem> ListOrderItemByDesignation(String designation);


}
