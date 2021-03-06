package com.codejava.InventoryApp.service;

import com.codejava.InventoryApp.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
}
