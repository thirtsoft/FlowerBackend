package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", length = 90)
    private String firstName;

    @Column(name = "lastName", length = 70)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "username", length = 30)
    private String username;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "password", length = 30)
    private String password;

    @Column(name = "mobile", length = 30)
    private String mobile;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orderList = new ArrayList<>();

    public Client(String firstName, String lastName, String mobile,
                  String email,
                  String username,
                  String password,
                  String name) {
    //    Utilisateur utilisateur = new Utilisateur();
        //    this.id = this.getId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;


    }

    public Client(String firstName, String lastName, String email, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;

    }

    public void add(Order order) {
        if (order != null) {
            if (orderList == null) {
                orderList = new ArrayList<>();
            }
            orderList.add(order);
            order.setClient(this);
        }
    }

}
