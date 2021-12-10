package com.flowers.controllers;

import com.flowers.controllers.api.OrderApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Order;
import com.flowers.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<Order> save(Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @Override
    public ResponseEntity<Order> update(Long id, Order order) {
        order.setId(id);
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @Override
    public ResponseEntity<Order> updateStatusOfOrder(String status, String id) {
        Order newOrder = orderService.updateStatusOfOrder(status, id);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> getById(Long id) {
        Order order = orderService.findOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return ResponseEntity.ok().body(order);
    }

    @Override
    public BigDecimal countNumberOfOrder() {
        return null;
    }

    @Override
    public BigDecimal countNumberOfOrdersInMonth() {
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
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orderList = orderService.findAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Order>> getAllOrdersOrderByIdDesc() {
        List<Order> orderList = orderService.findByOrderByIdDesc();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Order>> getListOrderByStatusPending() {
        List<Order> orderList = orderService.findListOrderByStatusPending();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Order>> getListOrderByStatusPayed() {
        List<Order> orderList = orderService.findListOrderByStatusPayed();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Order>> getOrdersByUserOrderByIdDesc(Long id) {
        List<Order> orderList = orderService.findListOrderByCustomerId(id);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Order>> getOrdersByBillingAddressOrderByIdDesc(Long id) {
        List<Order> orderList = orderService.findListOrderByAddressLivraisonId(id);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Order>> getOrdersByShippingAddressByIdDesc(Long id) {
        List<Order> orderList = orderService.findListOrderByAddressAchatId(id);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
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
    public Page<Order> getOrdersByUtilisateurIdByPageables(Long userId, int page, int size) {
        return null;
    }

    @Override
    public void delete(Long id) {
        orderService.deleteOrder(id);
    }
}
