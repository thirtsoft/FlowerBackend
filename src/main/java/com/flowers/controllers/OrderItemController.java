package com.flowers.controllers;

import com.flowers.controllers.api.OrderItemApi;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.OrderItem;
import com.flowers.services.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderItemController implements OrderItemApi {

    private final OrderItemService orderItemService;

    @Override
    public ResponseEntity<OrderItem> save(OrderItem orderItem) {
        return ResponseEntity.ok(orderItemService.saveOrderItem(orderItem));
    }

    @Override
    public ResponseEntity<OrderItem> update(Long id, OrderItem orderItem) {
        orderItem.setId(id);
        return ResponseEntity.ok(orderItemService.saveOrderItem(orderItem));
    }

    @Override
    public ResponseEntity<OrderItem> getOrderItemById(Long id) {
        OrderItem orderItem = orderItemService.findOrderItemById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found"));
        return ResponseEntity.ok().body(orderItem);
    }

    @Override
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItemList = orderItemService.findAllOrderItems();
        return new ResponseEntity<>(orderItemList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderItem>> getAllOrderItemOrderByIdDesc() {
        List<OrderItem> orderItemList = orderItemService.findByOrderByIdDesc();
        return new ResponseEntity<>(orderItemList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderItem>> getAllOrderItemsGroupByProductIdDesc() {
        List<OrderItem> orderItemList = orderItemService.findArticlesGroupByProductId();
        return new ResponseEntity<>(orderItemList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderItem>> getAllOrderItemsByOrderId(Long comId) {
        List<OrderItem> orderItemList = orderItemService.ListOrderItemByOrderId(comId);
        return new ResponseEntity<>(orderItemList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderItem>> getTop200OrderItemsOrderByIdDesc() {
        List<OrderItem> orderItemList = orderItemService.findTop200ByOrderByIdDesc();
        return new ResponseEntity<>(orderItemList, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        orderItemService.deleteOrderItem(id);
    }
}
