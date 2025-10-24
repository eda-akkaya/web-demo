package com.example.web_demo.mapper;

import com.example.web_demo.dto.category.request.CreateCategoryRequest;
import com.example.web_demo.dto.category.request.UpdateCategoryRequest;
import com.example.web_demo.dto.category.response.*;
import com.example.web_demo.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // List<Category> -> List<CreatedCategoryResponse>
    List<GetListCategoryResponse> toGetListCategoryResponse(List<Category> categoryList);

    // Category -> GetByIdCategoryResponse
    GetByIdCategoryResponse toGetByIdCategoryResponse(Category category);

    // Category -> CreatedCategoryResponse
    CreatedCategoryResponse toCreatedCategoryResponse(Category category);
    UpdatedCategoryResponse toUpdatedCategoryResponse(Category category);
    DeletedCategoryResponse toDeletedCategoryResponse(Category category);

    Category toCategory(CreateCategoryRequest createCategoryRequest);
    // @Mapping(target="id" , ignore=trye) : bu mappingde bu isimli elemanı görmezden gel
    Category toCategory(UpdateCategoryRequest updateCategoryRequest);


}
