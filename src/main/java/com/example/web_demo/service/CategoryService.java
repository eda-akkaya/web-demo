package com.example.web_demo.service;

import com.example.web_demo.entity.Category;
import com.example.web_demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    // kendi entity'sine ait repo
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // diğer servisler bu metodu kullanarak id'ye göre kategori bulabilsin
    public Optional<Category> findCategoryById(int id){
        // optional : o id ile kategori yoksa null dönmesi için.
        // ya dönüş tipini Optional<Category> yapmak gerek ya da sonuna orElse eklenmeli
        return  categoryRepository.findById(id);
    }
}
