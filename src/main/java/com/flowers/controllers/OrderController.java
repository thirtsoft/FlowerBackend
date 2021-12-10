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
    public BigDecimal countNumberOfOrder() {
        return orderService.countNumberOfOrder();
    }

    @Override
    public BigDecimal countNumberOfOrdersInMonth() {
        return orderService.countNumberOfOrdersInMonth();
    }

    @Override
    public BigDecimal countNumberOfOrdersByStatusPending() {
        return orderService.countNumberOfOrdersByStatusPending();
    }

    @Override
    public BigDecimal sumTotaleOfOrderByDay() {
        return orderService.sumTotalOfOrderByDay();
    }

    @Override
    public BigDecimal sumTotaleOfOrderByMonth() {
        return orderService.sumTotaleOfOrderByMonth();
    }

    @Override
    public BigDecimal sumTotaleOfOrderByYear() {
        return orderService.sumTotalOfOrdersByYear();
    }

    @Override
    public List<?> countNumberOfOrderByDay() {
        return orderService.countNumberOfOrderByDay();
    }

    @Override
    public List<?> countNumberOfOrderByMonth() {
        return orderService.countNumberTotalOfOrderByMonth();
    }

    @Override
    public List<?> getSumTotaleOfOrderByMonth() {
        return orderService.sumTotalOfOrderByMonth();
    }

    @Override
    public List<?> getSumTotalOfOrdersByYears() {
        return orderService.sumTotalOfOrdersByYears();
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
