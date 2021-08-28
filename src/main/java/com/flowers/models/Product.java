package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @Column(name = "manufactured", length = 250)
    @Lob
    private String manufactured;

    @ManyToOne
    @JoinColumn(name = "subCatId", nullable = false)
    private Subcategory subcategory;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Wishlist> wishlistList;

    public Product() {
    }

    public Product(Long id, String reference, String productName, double price,
                   int quantity, String imageUrl, boolean isSelected, boolean isPromo,
                   boolean isInstock, Date createdDate, Date updatedDated, String description,
                   String manufactured, Subcategory subcategory) {
        this.id = id;
        this.reference = reference;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.isSelected = isSelected;
        this.isPromo = isPromo;
        this.isInstock = isInstock;
        this.createdDate = createdDate;
        this.updatedDated = updatedDated;
        this.description = description;
        this.manufactured = manufactured;
        this.subcategory = subcategory;
    }

    public Product(Long id, String reference, String productName,
                   double price, int quantity, String imageUrl, boolean isSelected,
                   boolean isPromo, boolean isInstock,
                   String description, Subcategory subcategory) {
        this.id = id;
        this.reference = reference;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.isSelected = isSelected;
        this.isPromo = isPromo;
        this.isInstock = isInstock;
        this.description = description;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Date getUpdatedDated() {
        return updatedDated;
    }

    public void setUpdatedDated(Date updatedDated) {
        this.updatedDated = updatedDated;
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

    public List<Wishlist> getWishlistList() {
        return wishlistList;
    }

    public void setWishlistList(List<Wishlist> wishlistList) {
        this.wishlistList = wishlistList;
    }
}
