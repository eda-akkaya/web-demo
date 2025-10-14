package com.example.web_demo.controller;

import com.example.web_demo.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController //Spring tarafından RestController olarak tanınsın
@RequestMapping("/api/v1/products") // localhost:port/api/v1/products ile başlıyorsa istek buraya gelir.
public class ProductsController {
    private List<Product> products = new ArrayList<Product>();

    @GetMapping()
    public List<Product> getAll(){
        return null;
    }

    //best-practice: Ekleme endpointleri ekleme sonrası entity'i geri döner.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)// işlem başarılı olursa status code olarak bunu döner
    public Product add(@RequestBody Product product){
        Random random = new Random();
        product.setId(random.nextInt(1000));
        return product;
    }
}
