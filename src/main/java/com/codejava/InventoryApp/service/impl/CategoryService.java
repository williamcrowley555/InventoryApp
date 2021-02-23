package com.codejava.InventoryApp.service.impl;

import com.codejava.InventoryApp.model.Category;
import com.codejava.InventoryApp.repository.CategoryRepository;
import com.codejava.InventoryApp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
