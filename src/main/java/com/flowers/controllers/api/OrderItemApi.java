package com.flowers.controllers.api;

import com.flowers.models.OrderItem;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;

public interface OrderItemApi {

    @PostMapping(value = APP_ROOT + "/orderItems/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderItem> save(@RequestBody OrderItem orderItem);

    @GetMapping(value = APP_ROOT + "/orderItems/findById/{idOrderItem}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderItem> findById(@PathVariable("idOrderItem") Long id);

    @GetMapping(value = APP_ROOT + "/orderItems/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderItem> findAll();

    @DeleteMapping(value = APP_ROOT + "/orderItems/delete/{idOrderItem}")
    void delete(@PathVariable("idOrderItem") Long id);
}
