package com.codejava.InventoryApp.service;

import com.codejava.InventoryApp.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategories();
    Category saveCategory(Category category);
}
