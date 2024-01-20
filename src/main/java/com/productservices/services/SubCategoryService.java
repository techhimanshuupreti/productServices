package com.productservices.services;

import com.productservices.dtos.SubCategoryDTO;
import com.productservices.entities.Category;
import com.productservices.entities.SubCategory;
import com.productservices.repositories.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    private final CategoryService categoryService;

    @Transactional
    public boolean save(SubCategoryDTO subCategoryDTO) {

        Category category = categoryService.findOne(subCategoryDTO.getCategoryId());
        if (category == null) return false;

        SubCategory subCategory = new SubCategory();
        subCategory.setCategory(category);
        subCategory.setDescriptions(subCategoryDTO.getDescriptions());
        subCategoryDTO.setShortDescriptions(subCategoryDTO.getShortDescriptions());
        subCategory.setName(subCategoryDTO.getName());
        subCategory.setCreatedAt(Calendar.getInstance().getTime());
        subCategory.setUpdatedAt(Calendar.getInstance().getTime());
        subCategoryRepository.save(subCategory);
        return true;
    }

    public List<SubCategory> findAll() {
        return subCategoryRepository.findAll();
    }

    public SubCategory findOne(String id) {
        if (id == null || id.isEmpty() || id.isBlank()) return null;

        return subCategoryRepository.findById(id).orElseGet(null);
    }

    public boolean remove(String id) {
        if (id == null || id.isEmpty() || id.isBlank()) return false;

        subCategoryRepository.deleteById(id);
        return true;
    }
}
