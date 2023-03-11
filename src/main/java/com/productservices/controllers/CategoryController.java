package com.productservices.controllers;

import com.productservices.services.CategoryService;
import com.productservices.dtos.CategoryDTO;
import com.productservices.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }
    @GetMapping("/{id}")
    public Category findOne(@PathVariable String id){
        return categoryService.findOne(id);
    }

    @PostMapping
    public boolean save(@RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    @DeleteMapping("/{id}")
    public boolean removeCategory(@PathVariable String id){
        return categoryService.removeCategory(id);
    }
}
