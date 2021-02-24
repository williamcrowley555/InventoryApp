package com.codejava.InventoryApp.service;

import com.codejava.InventoryApp.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
}
