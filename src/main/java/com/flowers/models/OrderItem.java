package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderItem")
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reference")
    private String reference;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;


    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "prodId", nullable = false)
    private Product product;
}
