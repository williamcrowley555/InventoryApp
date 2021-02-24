package com.codejava.InventoryApp.controller;

import com.codejava.InventoryApp.model.Category;
import com.codejava.InventoryApp.model.Product;
import com.codejava.InventoryApp.service.ICategoryService;
import com.codejava.InventoryApp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = {"", "/"})
    public String listCategories(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList" , productList);
        return "products";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryList);
        return "product_form";
    }

    @PostMapping("saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
