package com.productservices.services;

import com.productservices.dtos.ProductDTO;
import com.productservices.entities.Product;
import com.productservices.entities.SubCategory;
import com.productservices.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServices {

    private final ProductRepository productRepository;

    private final SubCategoryService subCategoryService;

    @Transactional
    public boolean save(ProductDTO productDTO) {

        SubCategory subCategory = subCategoryService.findOne(productDTO.getSubCategoryId());
        if (subCategory == null) return false;

        Product product = new Product();
        product.setProductNumbers(product.getProductNumbers());
        product.setName(productDTO.getName());
        product.setDescriptions(productDTO.getDescriptions());
        product.setPrice(product.getPrice());
        product.setShortDescriptions(productDTO.getShortDescriptions());
        product.setCompanyName(product.getCompanyName());
        product.setCreatedAt(Calendar.getInstance().getTime());
        product.setUpdatedAt(Calendar.getInstance().getTime());
        product.setDistributorSupplierName(productDTO.getDistributorSupplierName());
        productRepository.save(product);
        return true;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(String id) {
        if (id == null || id.isBlank() || id.isEmpty()) return null;

        return productRepository.findById(id).orElseGet(null);
    }

    public boolean remove(String id) {
        if (id == null || id.isBlank() || id.isEmpty()) return false;

        productRepository.deleteById(id);
        return true;
    }

}
