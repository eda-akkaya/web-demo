package com.example.web_demo.rules;

import com.example.web_demo.Core.exception.type.BusinessException;
import com.example.web_demo.entity.Category;
import com.example.web_demo.repository.CategoryRepository;
import org.springframework.stereotype.Component;


@Component
public class CategoryBusinessRules {
    private final CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category categoryShouldExistWithGivenId(int id){
        //böyle bir kategori varsa geri döndürür, yoksa hata fırlatır
        return categoryRepository
                .findById(id)
                .orElseThrow(()->new BusinessException("id'si " + id + "olan kategori bulunamadı."));
    }

    public void categoryShouldNotExistWithSameName(String name){
       Category category = categoryRepository
                .findTop1ByNameIgnoreCase(name)
               .orElse(null);

       if (category != null){
           throw new BusinessException("Adı " + name + " olan bir kategori zaten mevcut,ekleyemezsiniz.");
       }
    }



}