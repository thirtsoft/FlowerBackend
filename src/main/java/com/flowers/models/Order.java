package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroOrder", length = 70)
    private Long numeroOrder;

    @Column(name = "totalPrice")
    private double totalPrice;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "status")
    private String status;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "orderTrackingNumber")
    private String orderTrackingNumber;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Utilisateur utilisateur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;

    public Order() {
    }

    public void add(OrderItem orderItem) {
        if (orderItem != null) {
            if (orderItemList == null) {
                orderItemList = new ArrayList<>();
            }
            orderItemList.add(orderItem);
            orderItem.setOrder(this);
        }
    }

}
