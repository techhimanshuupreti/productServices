package com.productservices.controllers;

import com.productservices.dtos.ProductDTO;
import com.productservices.entities.Product;
import com.productservices.services.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productServices;

    @PostMapping
    public boolean save(ProductDTO productDTO) {
        return productServices.save(productDTO);
    }

    @GetMapping
    public List<Product> findAll() {
        return productServices.findAll();
    }

    @GetMapping("{id}")
    public Product findOne(@PathVariable String id) {
        return productServices.findOne(id);
    }

    @DeleteMapping("{id}")
    public boolean remove(@PathVariable String id) {
        return productServices.remove(id);
    }


}
