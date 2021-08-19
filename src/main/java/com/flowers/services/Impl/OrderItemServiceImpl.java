package com.flowers.services.Impl;

import com.flowers.models.OrderItem;
import com.flowers.reposiory.OrderItemRepository;
import com.flowers.services.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findAllOrderItems() {
        return null;
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return null;
    }

    @Override
    public Optional<OrderItem> findOrderItemById(Long id) {
        return Optional.empty();
    }

    @Override
    public OrderItem updateOrderItem(Long Id, OrderItem orderItem) {
        return null;
    }

    @Override
    public void deleteOrderItem(Long Id) {

    }

    @Override
    public OrderItem findByCode(String code) {
        return null;
    }

    @Override
    public OrderItem findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<OrderItem> ListOrderItemByCode(String designation) {
        return null;
    }

    @Override
    public List<OrderItem> ListOrderItemByDesignation(String designation) {
        return null;
    }
}
