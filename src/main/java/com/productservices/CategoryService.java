package com.productservices;

import com.productservices.entities.Category;
import com.productservices.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
      return  categoryRepository.findAll();
    }

    public boolean save(){
        Category category = new Category();
        category.setCategoryType("BOTH");
        category.setCreatedAt(Calendar.getInstance().getTime());
        category.setUpdatedAt(Calendar.getInstance().getTime());
        category.setDescriptions("electronic items");
        category.setName("Electronic");
        category.setShortDescriptions("electronic items");
        categoryRepository.save(category);
        return true;
    }
}
