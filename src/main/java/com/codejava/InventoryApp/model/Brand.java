package com.codejava.InventoryApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Brand")
@Table(name = "brand",
        uniqueConstraints = {
        @UniqueConstraint(name = "brand_name_unique", columnNames = "name")
        })
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "brand_id")
    private List<Category> categories = new ArrayList<>();

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
