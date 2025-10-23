package com.example.web_demo.controller;

import com.example.web_demo.dto.product.request.CreateProductRequest;
import com.example.web_demo.dto.product.request.SearchProductRequest;
import com.example.web_demo.dto.product.response.CreatedProductResponse;
import com.example.web_demo.dto.product.response.GetByIdProductResponse;
import com.example.web_demo.dto.product.response.SearchProductResponse;
import com.example.web_demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Spring tarafından RestController olarak tanınsın
@RequestMapping("/api/v1/products") // localhost:port/api/v1/products ile başlıyorsa istek buraya gelir.
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@Valid @RequestBody CreateProductRequest createProductRequest){
        return productService.add(createProductRequest);
    }

    @GetMapping("{id}")
    public GetByIdProductResponse getById(@PathVariable int id){
        return productService.getById(id);
    }
    @GetMapping("search")
    public List<SearchProductResponse> search(SearchProductRequest request){
        return productService.search(request);
    }


}
