package com.example.web_demo.rules;

import com.example.web_demo.entity.Category;
import com.example.web_demo.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class CategoryBusinessRules {
    private final CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category categoryShouldExistWithGivenId(int id){
        return categoryRepository
                .findById(id)
                .orElseThrow(()->new NotFoundException(id + "id'ye sahip kategori bulunamadı."));

    }
}