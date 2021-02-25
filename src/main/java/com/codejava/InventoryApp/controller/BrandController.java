package com.codejava.InventoryApp.controller;

import com.codejava.InventoryApp.model.Brand;
import com.codejava.InventoryApp.model.Category;
import com.codejava.InventoryApp.service.IBrandService;
import com.codejava.InventoryApp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = {"", "/"})
    public String listBrands(Model model) {
        List<Brand> brandList = brandService.getAllBrands();
        model.addAttribute("brandList" , brandList);
        return "brands";
    }

    @GetMapping("/new")
    public String showNewBrandForm(Model model) {
        Brand brand = new Brand();
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("brand", brand);
        model.addAttribute("categoryList", categoryList);
        return "brand_form";
    }

    @PostMapping("saveBrand")
    public String saveBrand(@ModelAttribute("brand") Brand brand) {
        brandService.saveBrand(brand);
        return "redirect:/brands";
    }

    @GetMapping("/edit/{id}")
    public String showEditBrandForm(Model model, @PathVariable("id") Long id) {
        Brand brand = brandService.getBrandById(id);
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("brand", brand);
        model.addAttribute("categoryList", categoryList);
        return "brand_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(Model model, @PathVariable("id") Long id) {
        brandService.deleteBrandById(id);
        return "redirect:/brands";
    }
}
