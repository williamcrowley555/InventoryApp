package com.codejava.InventoryApp.service.impl;

import com.codejava.InventoryApp.model.Brand;
import com.codejava.InventoryApp.repository.BrandRepository;
import com.codejava.InventoryApp.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements IBrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(Long id) {
        Optional<Brand> optional = brandRepository.findById(id);
        Brand brand = null;
        if (optional.isPresent()) {
            brand = optional.get();
        } else {
            throw new RuntimeException("Brand ID: " + id + " does not exist");
        }
        return brand;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);
    }
}
