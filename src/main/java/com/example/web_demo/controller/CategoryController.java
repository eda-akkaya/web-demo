package com.example.web_demo.controller;

import com.example.web_demo.dto.category.request.CreateCategoryRequest;
import com.example.web_demo.dto.category.request.UpdateCategoryRequest;
import com.example.web_demo.dto.category.response.*;
import com.example.web_demo.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListResourceBundle;

@RestController
@RequestMapping("/api/v1/categories")
@Validated
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<GetListCategoryResponse> getList(){
        return categoryService.getList();
    }

    @GetMapping("{id}")
    public GetByIdCategoryResponse getById(@Valid @PathVariable int id){
        return categoryService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCategoryResponse add(@Valid @RequestBody CreateCategoryRequest request){
        return categoryService.add(request);

    }
    @PutMapping
    public UpdatedCategoryResponse update(@Valid @RequestBody UpdateCategoryRequest request){
        return categoryService.update(request);
    }

    @DeleteMapping("{id}")
    public DeletedCategoryResponse delete(@PathVariable int id){
        return categoryService.delete(id);
    }

}

