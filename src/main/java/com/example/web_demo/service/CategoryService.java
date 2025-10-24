package com.example.web_demo.service;

import com.example.web_demo.entity.Category;
import com.example.web_demo.repository.CategoryRepository;
import com.example.web_demo.rules.CategoryBusinessRules;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    // kendi entity'sine ait repo
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;

    public CategoryService(CategoryRepository categoryRepository, CategoryBusinessRules categoryBusinessRules) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRules = categoryBusinessRules;
    }


}
