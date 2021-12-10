package com.flowers.services.Impl;

import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.models.Order;
import com.flowers.reposiory.OrderRepository;
import com.flowers.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        if (order.getNumeroOrder() != null) {
            throw new ResourceNotFoundException("Order already exists");
        }
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long Id, Order order) {
        if (!orderRepository.existsById(Id)) {
            throw new ResourceNotFoundException("Order that id is" + Id + "is not found");
        }
        Optional<Order> orderOptional = orderRepository.findById(Id);

        if (!orderOptional.isPresent()) {
            throw new ResourceNotFoundException("Order not found");
        }
        Order orderResult = orderOptional.get();
        orderResult.setNumeroOrder(order.getNumeroOrder());
        orderResult.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResult.setSessionId(order.getSessionId());
        orderResult.setStatus(order.getStatus());
        orderResult.setTotalPrice(order.getTotalPrice());
        orderResult.setTotalQuantity(order.getTotalQuantity());
        orderResult.setOrderDate(new Date());
        orderResult.setClient(order.getClient());
        orderResult.setUtilisateur(order.getUtilisateur());
        orderResult.setBillingAddress(order.getBillingAddress());
        orderResult.setShippingAddress(order.getShippingAddress());
        orderResult.setOrderItemList(order.getOrderItemList());

        return orderRepository.save(orderResult);
    }

    @Override
    public Order updateStatusOfOrder(String status, String id) {

        Optional<Order> orderOptional = orderRepository.findById(Long.valueOf(id));

        Order orderResult = orderOptional.get();

        orderResult.setStatus(status);

        return orderRepository.save(orderResult);
    }

    @Override
    public Optional<Order> findOrderById(Long id) {

        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order that id is " + id + "not found");
        }

        return orderRepository.findById(id);

    }


    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByOrderByIdDesc() {
        return orderRepository.findByOrderByIdDesc();
    }

    @Override
    public List<Order> findListOrderByStatusPending() {
        return orderRepository.findListOrderByStatusPending();
    }

    @Override
    public List<Order> findListOrderByStatusPayed() {
        return orderRepository.findListOrderByStatusPayed();
    }

    @Override
    public List<Order> findListOrderByCustomerId(Long userId) {
        return orderRepository.ListOrderByCustomerId(userId);
    }

    @Override
    public List<Order> findListOrderByAddressLivraisonId(Long addLivraison) {
        return orderRepository.ListOrderByAddressLivraisonId(addLivraison);
    }

    @Override
    public List<Order> findListOrderByAddressAchatId(Long addAchat) {
        return orderRepository.ListOrderByAddressAchatId(addAchat);
    }

    @Override
    public void deleteOrder(Long Id) {
        if (!orderRepository.existsById(Id)) {
            throw new ResourceNotFoundException("Order that id is " + Id + "not found");
        }

        orderRepository.deleteById(Id);
    }

}
