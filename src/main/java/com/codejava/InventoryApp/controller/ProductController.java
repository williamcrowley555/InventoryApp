package com.codejava.InventoryApp.controller;

import com.codejava.InventoryApp.model.Category;
import com.codejava.InventoryApp.model.Product;
import com.codejava.InventoryApp.service.ICategoryService;
import com.codejava.InventoryApp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = {"", "/"})
    public String listProducts(Model model) {
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
    public String saveProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {
        String[] detailIds = request.getParameterValues("detailId");
        String[] detailNames = request.getParameterValues("detailName");
        String[] detailValues = request.getParameterValues("detailValue");

        for(int i = 0; i < detailNames.length; ++i) {
            if (detailIds != null && detailIds.length > 0) {
                product.setDetail(Long.valueOf(detailIds[i]), detailNames[i], detailValues[i]);
            } else {
                if (!(detailNames[i].isEmpty() && detailValues[i].isEmpty())) {
                    product.addDetail(detailNames[i], detailValues[i]);
                }
            }
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(Model model, @PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryList);
        return "product_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
