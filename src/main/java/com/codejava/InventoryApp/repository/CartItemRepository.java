package com.codejava.InventoryApp.repository;

import com.codejava.InventoryApp.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
