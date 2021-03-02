package com.codejava.InventoryApp.model;

import javax.persistence.*;

@Entity(name = "CartItem")
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CartItem() {
    }

    public CartItem(Integer quantity, Product product, User user) {
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    public CartItem(Long id, Integer quantity, Product product, User user) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
