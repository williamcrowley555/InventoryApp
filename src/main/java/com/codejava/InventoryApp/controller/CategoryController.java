package com.codejava.InventoryApp.controller;

import com.codejava.InventoryApp.model.Category;
import com.codejava.InventoryApp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = {"", "/"})
    public String listCategories(Model model) {
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList" , categoryList);
        return "categories";
    }

    @GetMapping("/new")
    public String showNewCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category_form";
    }

    @PostMapping("saveCategory")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
}
