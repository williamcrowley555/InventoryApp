package com.codejava.InventoryApp.service.impl;

import com.codejava.InventoryApp.model.Category;
import com.codejava.InventoryApp.repository.CategoryRepository;
import com.codejava.InventoryApp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;
        if (optional.isPresent()) {
            category = optional.get();
        } else {
            throw new RuntimeException("Category Id:" + id + " does not exist");
        }
        return category;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
