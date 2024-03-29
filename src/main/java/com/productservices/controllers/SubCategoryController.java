package com.productservices.controllers;

import com.productservices.dtos.SubCategoryDTO;
import com.productservices.entities.SubCategory;
import com.productservices.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sub-category")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping
    public boolean save(SubCategoryDTO subCategoryDTO) {
        return subCategoryService.save(subCategoryDTO);
    }

    @GetMapping
    public List<SubCategory> findAll() {
        return subCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public SubCategory findOne(@PathVariable String id) {
        return subCategoryService.findOne(id);
    }

    @DeleteMapping("{id}")
    public boolean remove(@PathVariable String id) {
        return subCategoryService.remove(id);
    }
}
