package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fournisseur")
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reference", nullable = false, length = 30)
    private String reference;
    @Column(name = "firstName", length = 90)
    private String firstName;
    @Column(name = "lastName", length = 90)
    private String lastName;
    @Column(name = "address", length = 150)
    private String address;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "telephone", length = 30)
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "prodId", nullable = false)
    private Product product;


}
