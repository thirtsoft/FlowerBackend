package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
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
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public Optional<OrderItem> findOrderItemById(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("OrderItem that id is " + id + "not found");
        }
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem updateOrderItem(Long Id, OrderItem orderItem) {
        if (!orderItemRepository.existsById(Id)) {
            throw new ResourceNotFoundException("OrderItem that id is" + Id + "is not found");
        }
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(Id);

        if (!optionalOrderItem.isPresent()) {
            throw new ResourceNotFoundException("OrderItem not found");
        }

        OrderItem orderItemResult = optionalOrderItem.get();
        orderItemResult.setNumero(orderItem.getNumero());
        orderItemResult.setPrice(orderItem.getPrice());
        orderItemResult.setQuantity(orderItem.getQuantity());
        orderItemResult.setProductName(orderItem.getProductName());
        orderItemResult.setOrder(orderItem.getOrder());
        orderItemResult.setProduct(orderItem.getProduct());
        orderItemResult.setProductId(orderItem.getProductId());
        orderItemResult.setCreatedDate(orderItem.getCreatedDate());

        return orderItemRepository.save(orderItemResult);
    }


    @Override
    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public List<OrderItem> findArticlesGroupByProductId() {
        return orderItemRepository.findArticlesGroupByProductId();
    }

    @Override
    public List<OrderItem> findByOrderByIdDesc() {
        return orderItemRepository.findByOrderByIdDesc();
    }

    @Override
    public List<OrderItem> ListOrderItemByOrderId(Long comId) {
        return orderItemRepository.ListOrderItemByOrderId(comId);
    }

    @Override
    public List<OrderItem> findTop200ByOrderByIdDesc() {
        return orderItemRepository.findTop200ByOrderByIdDesc();
    }

    @Override
    public void deleteOrderItem(Long Id) {
        if (!orderItemRepository.existsById(Id)) {
            throw new ResourceNotFoundException("OrderItem that id is" + Id + "is not found");
        }
        orderItemRepository.deleteById(Id);
    }

}
