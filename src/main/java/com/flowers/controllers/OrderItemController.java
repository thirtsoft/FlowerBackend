package com.flowers.controllers;

import com.flowers.controllers.api.OrderItemApi;
import com.flowers.models.OrderItem;
import com.flowers.services.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderItemController implements OrderItemApi {

    private final OrderItemService orderItemService;

    @Override
    public ResponseEntity<OrderItem> save(OrderItem orderItem) {
        return null;
    }

    @Override
    public ResponseEntity<OrderItem> findById(Long id) {
        return null;
    }

    @Override
    public List<OrderItem> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
