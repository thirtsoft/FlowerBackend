package com.flowers.services;

import com.flowers.models.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {

    OrderItem saveOrderItem(OrderItem orderItem);

    Optional<OrderItem> findOrderItemById(Long id);

    OrderItem updateOrderItem(Long Id, OrderItem orderItem);

    List<OrderItem> findAllOrderItems();

    List<OrderItem> findArticlesGroupByProductId();

    List<OrderItem> findByOrderByIdDesc();

    List<OrderItem> ListOrderItemByOrderId(Long comId);

    List<OrderItem> findTop200ByOrderByIdDesc();

    void deleteOrderItem(Long Id);

}
