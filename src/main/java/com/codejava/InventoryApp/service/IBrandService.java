package com.codejava.InventoryApp.service;

import com.codejava.InventoryApp.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBrandService {
    List<Brand> getAllBrands();
    Brand getBrandById(Long id);
    Brand saveBrand(Brand brand);
    void deleteBrandById(Long id);
}
