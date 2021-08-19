package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reference", nullable = false, length = 30, unique = true)
    private String reference;
    @Column(name = "nombreEtoile")
    private String nombreEtoile;

    private String description;
    @Column(name = "observation", nullable = false, length = 250)
    @Lob
    private String observation;

    @ManyToOne
    @JoinColumn(name = "prodId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Utilisateur utilisateur;


}
