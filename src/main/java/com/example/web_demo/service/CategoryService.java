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

    // diğer servisler bu metodu kullanarak id'ye göre kategori bulabilsin
    public Optional<Category> findCategoryById(int id){
        //business rule buradan da çağrılabilir

        // optional : o id ile kategori yoksa null dönmesi için.
        // ya dönüş tipini Optional<Category> yapmak gerek ya da sonuna orElse eklenmeli
        return  categoryRepository.findById(id);

    }
}
