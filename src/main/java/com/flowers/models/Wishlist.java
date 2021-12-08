package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wishlist")
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference", length = 30)
    private String reference;

    @Column(name = "nombreEtoile")
    private String nombreEtoile;

    private String description;
    @Column(name = "observation", length = 100)
    @Lob
    private String observation;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Utilisateur utilisateur;


}
