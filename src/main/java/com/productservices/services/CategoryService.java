package com.productservices.services;

import com.productservices.dtos.CategoryDTO;
import com.productservices.entities.Category;
import com.productservices.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public boolean save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCreatedAt(Calendar.getInstance().getTime());
        category.setUpdatedAt(Calendar.getInstance().getTime());
        category.setDescriptions(categoryDTO.getDescriptions());
        category.setName(categoryDTO.getName());
        category.setShortDescriptions(categoryDTO.getShortDescriptions());
        categoryRepository.save(category);
        return true;
    }

    public Category findOne(String id) {
        if (id == null || id.isBlank() || id.trim().isEmpty()) return null;

        return categoryRepository.findById(id).get();
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public boolean removeCategory(String id) {
        if (id == null || id.isBlank() || id.trim().isEmpty()) return false;
        categoryRepository.deleteById(id);
        return true;
    }
}
