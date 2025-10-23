package com.example.web_demo.Mapper;

import com.example.web_demo.dto.product.request.CreateProductRequest;
import com.example.web_demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Dışarıdan bu mapper'a erişim için
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    //createProductRequest -> Product
    @Mapping(target="category.id", source = "categoryId")
    Product createProductRequestToProduct(CreateProductRequest createProductRequest);
}
