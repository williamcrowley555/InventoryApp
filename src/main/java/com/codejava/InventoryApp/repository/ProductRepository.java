package com.codejava.InventoryApp.repository;

import com.codejava.InventoryApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
