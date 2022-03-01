package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orderItem")
public class LigneCommande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", length = 90)
    private Long numero;

    @Column(name = "quantity", length = 70)
    private int quantity;

    @Column(name = "price", length = 90)
    private double price;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName", length = 150)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "comId", referencedColumnName = "id")
    @JsonIgnore
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "prodId", referencedColumnName = "id")
    private Product product;

    public LigneCommande() {
    }

    public LigneCommande(Commande commande, Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.commande = commande;
        this.createdDate = new Date();

    }

    public LigneCommande(Long id, int quantity, double price, Commande commande, Product product) {
        this.id = id;
        this.numero = commande.getNumeroCommande();
        this.quantity = quantity;
        this.price = price;
        this.createdDate = new Date();
        this.commande = commande;
        this.product = product;
    }

    public LigneCommande(Long id, Long numero, int quantity, double price, Commande commande, Product product) {
        this.id = id;
        this.numero = numero;
        this.quantity = quantity;
        this.price = price;
        this.createdDate = new Date();
        this.commande = commande;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


}
