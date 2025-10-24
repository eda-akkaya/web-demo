package com.example.web_demo.service;

import com.example.web_demo.dto.category.request.CreateCategoryRequest;
import com.example.web_demo.dto.category.request.UpdateCategoryRequest;
import com.example.web_demo.dto.category.response.*;
import com.example.web_demo.entity.Category;
import com.example.web_demo.mapper.CategoryMapper;
import com.example.web_demo.repository.CategoryRepository;
import com.example.web_demo.rules.CategoryBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class CategoryService {

    // kendi entity'sine ait repo
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryBusinessRules categoryBusinessRules, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRules = categoryBusinessRules;
        this.categoryMapper = categoryMapper;
    }

    public List<GetListCategoryResponse> getList(){
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toGetListCategoryResponse(categories);
    }

    public GetByIdCategoryResponse getById(int id){
        // iş kuralı
        Category category = categoryBusinessRules.categoryShouldExistWithGivenId(id);
        return categoryMapper.toGetByIdCategoryResponse(category);
    }

    public CreatedCategoryResponse add(@Valid CreateCategoryRequest request){
        categoryBusinessRules.categoryShouldNotExistWithSameName(request.getName());

        // CreateCategoryRequest -> Category (repository'e save et) -> CreatedCategoryResponse(döndür)
        Category category = categoryMapper.toCategory(request); //CreateCategoryRequest -> Category
        category = categoryRepository.save(category); // (repository'e save et) save edilirken alanlar atandığı için tekrar category'e eşitle
        return categoryMapper.toCreatedCategoryResponse(category);//Category -> CreatedCategoryResponse(döndür)
    }

    public UpdatedCategoryResponse update(@Valid UpdateCategoryRequest request){
        Category category = categoryBusinessRules.categoryShouldExistWithGivenId(request.getId());
        categoryBusinessRules.categoryShouldNotExistWithSameName(request.getName());

        category = categoryMapper.toCategory(request);
        category = categoryRepository.save(category); //save metodu direkt update yapar
        return categoryMapper.toUpdatedCategoryResponse(category);

    }

    public DeletedCategoryResponse delete(int id){
        Category category = categoryBusinessRules.categoryShouldExistWithGivenId(id);
        categoryRepository.delete(category);

        return categoryMapper.toDeletedCategoryResponse(category);
    }

}
