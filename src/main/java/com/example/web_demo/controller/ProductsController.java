package com.example.web_demo.controller;

import com.example.web_demo.entity.Product;
import com.example.web_demo.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController //Spring tarafından RestController olarak tanınsın
@RequestMapping("/api/v1/products") // localhost:port/api/v1/products ile başlıyorsa istek buraya gelir.
public class ProductsController {
    private ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    //best-practice: Ekleme endpointleri ekleme sonrası entity'i geri döner.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)// işlem başarılı olursa status code olarak bunu döner
    public Product add(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }
}
