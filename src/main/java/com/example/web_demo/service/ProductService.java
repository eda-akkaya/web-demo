package com.example.web_demo.service;

import com.example.web_demo.dto.product.ProductForAddDto;
import com.example.web_demo.entity.Category;
import com.example.web_demo.entity.Product;
import com.example.web_demo.repository.ProductRepository;

import java.util.List;
public class ProductService{

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getAll(){
        return null;
    }

    public Product add(ProductForAddDto productForAddDto){
        //mapping
        Product product = new Product();
        product.setName(productForAddDto.getName());
        product.setDescription(productForAddDto.getDescription());
        product.setStock(productForAddDto.getStock());
        product.setPrice(productForAddDto.getUnitPrice());

        Category category = new Category();
        category.setId(productForAddDto.getCategoryId());

        product.setCategory(category);
        return this.productRepository.save(product);

    }
}
