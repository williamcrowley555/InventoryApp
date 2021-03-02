package com.codejava.InventoryApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product",
        uniqueConstraints = {
        @UniqueConstraint(name = "product_name_unique", columnNames = "name")
        })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductDetail> productDetails = new ArrayList<>();

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public void addDetail(String name, String value) {
        this.productDetails.add(new ProductDetail(name, value, this));
    }

    public void setDetail(Long id, String name, String value) {
        this.productDetails.add(new ProductDetail(id, name, value, this));
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", category=" + category +
//                '}';
//    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
