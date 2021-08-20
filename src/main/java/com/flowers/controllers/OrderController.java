package com.flowers.controllers;

import com.flowers.controllers.api.OrderApi;
import com.flowers.models.Order;
import com.flowers.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<Order> save(Order order) {
        return null;
    }

    @Override
    public ResponseEntity<Order> update(Long id, Order order) {
        return null;
    }

    @Override
    public ResponseEntity<Order> findById(Long id) {
        return null;
    }

    @Override
    public BigDecimal countNumberOfOrder() {
        return null;
    }

    @Override
    public BigDecimal sumTotaleOfOrderByMonth() {
        return null;
    }

    @Override
    public BigDecimal sumTotaleOfOrderByYear() {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<?> countNumberOfOrderByMonth() {
        return null;
    }

    @Override
    public List<?> getSumTotaleOfOrderByMonth() {
        return null;
    }

    @Override
    public Page<Order> getListOrderByCustomerByPageables(Long clientId, int page, int size) {
        return null;
    }

    @Override
    public Page<Order> getListOrderByUtilisateurByPageables(Long userId, int page, int size) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
