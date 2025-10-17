package com.example.web_demo.service;

import com.example.web_demo.dto.product.request.CreateProductRequest;
import com.example.web_demo.dto.product.response.CreatedProductResponse;
import com.example.web_demo.entity.Category;
import com.example.web_demo.entity.Product;
import com.example.web_demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService{

    // repository bağımlılığı
    // final: yalnızca construvtor üzerinden set edilebilir olması için
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public CreatedProductResponse add(CreateProductRequest createProductRequest){
        // add logic
        Product product = new Product();

        product.setName(createProductRequest.getName());
        product.setUnitPrice(createProductRequest.getUnitPrice());
        product.setStock(createProductRequest.getStock());
        product.setDescription(createProductRequest.getDescription());

        //TODO: Fix
        Category category = new Category();
        category.setId(createProductRequest.getCategoryId());

        product.setCategory(category);
        productRepository.save(product);
        return new CreatedProductResponse(product.getId(),
                                            product.getName(),
                                            product.getStock(),
                                            product.getDescription(),
                                            product.getUnitPrice());
    }
}
