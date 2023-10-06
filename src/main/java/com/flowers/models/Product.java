package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "reference"
        })
})
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference", nullable = false, length = 30, unique = true)
    private String reference;

    @Column(name = "designation", nullable = false, length = 150)
    private String designation;

    @Column(name = "price", nullable = false, length = 70)
    private double price;

    @Column(name = "currentPrice", nullable = false, length = 70)
    private double currentPrice;

    @Column(name = "quantity", nullable = false, length = 30)
    private int quantity;

    @Transient
    private int quantite = 1;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "isSelected")
    private boolean isSelected;

    @Column(name = "isPromo")
    private boolean isPromo;

    @Column(name = "isInStock")
    private boolean isInstock;

    @Column(name = "description", length = 250)
    @Lob
    private String description;

    @Column(name = "manufactured", length = 250)
    @Lob
    private String manufactured;

    @Column(name = "createdDate")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "lastUpDated")
    @UpdateTimestamp
    private Date lastUpDated;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scatId")
    private Subcategory subcategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fournisseur_uid")
    private Fournisseur fournisseur;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Rating> ratingList;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Wishlist> wishlistList;

    @Column(name = "actif")
    private int actif;

    public void setActif(boolean actif) {
        if (actif == true)
            this.actif = 1;
        else
            this.actif = 0;
    }

    public boolean isActif() {
        if (actif == 1)
            return true;
        else
            return false;
    }

    public Product() {
    }

    public Product(Long id, String reference, String designation, int quantity,
                   double price, double currentPrice, boolean isPromo, boolean isSelected,
                   String description, String imageUrl, Subcategory subcategory) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.quantity = quantity;
        this.price = price;
        this.currentPrice = currentPrice;
        this.isPromo = isPromo;
        this.isSelected = isSelected;
        this.description = description;
        this.imageUrl = imageUrl;
        this.subcategory = subcategory;
    }

    public Product(Long id, String reference, String designation,
                   double price, double currentPrice, int quantity,
                   String imageUrl, boolean isSelected,
                   boolean isPromo, boolean isInstock,
                   String description, String manufactured, Subcategory subcategory) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.price = price;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.isSelected = isSelected;
        this.isPromo = isPromo;
        this.isInstock = isInstock;
        this.description = description;
        this.manufactured = manufactured;
        this.subcategory = subcategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public boolean isInstock() {
        return isInstock;
    }

    public void setInstock(boolean instock) {
        isInstock = instock;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpDated() {
        return lastUpDated;
    }

    public void setLastUpDated(Date lastUpDated) {
        this.lastUpDated = lastUpDated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Wishlist> getWishlistList() {
        return wishlistList;
    }

    public void setWishlistList(List<Wishlist> wishlistList) {
        this.wishlistList = wishlistList;
    }
}
