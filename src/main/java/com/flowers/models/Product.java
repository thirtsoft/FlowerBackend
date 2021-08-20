package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference", nullable = false, length = 30, unique = true)
    private String reference;

    @Column(name = "productName", nullable = false, length = 150)
    private String productName;

    @Column(name = "price", nullable = false, length = 30)
    private double price;

    @Column(name = "quantity", nullable = false, length = 30)
    private int quantity;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "isSelected")
    private boolean isSelected;

    @Column(name = "isPromo")
    private boolean isPromo;

    @Column(name = "isInStock")
    private boolean isInstock;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDated")
    private Date updatedDated;

    @Column(name = "description", length = 250)
    @Lob
    private String description;

    @Column(name = "manufactured", nullable = false, length = 250)
    @Lob
    private String manufactured;

    @ManyToOne
    @JoinColumn(name = "subCatId", nullable = false)
    private Subcategory subcategory;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Wishlist> wishlistList;
}
