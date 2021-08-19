package com.flowers.services.Impl;

import com.flowers.models.Order;
import com.flowers.reposiory.OrderRepository;
import com.flowers.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return null;
    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        return Optional.empty();
    }

    @Override
    public Order updateOrder(Long Id, Order order) {
        return null;
    }

    @Override
    public void deleteOrder(Long Id) {

    }

    @Override
    public Order findByCode(String code) {
        return null;
    }

    @Override
    public Order findByDesignation(String designation) {
        return null;
    }

    @Override
    public List<Order> ListOrderByCode(String designation) {
        return null;
    }

    @Override
    public List<Order> ListOrderByDesignation(String designation) {
        return null;
    }
}
