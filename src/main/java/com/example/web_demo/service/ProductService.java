package com.example.web_demo.service;

import com.example.web_demo.dto.product.request.CreateProductRequest;
import com.example.web_demo.dto.product.request.SearchProductRequest;
import com.example.web_demo.dto.product.response.CreatedProductResponse;
import com.example.web_demo.dto.product.response.GetByIdProductResponse;
import com.example.web_demo.dto.product.response.SearchProductResponse;
import com.example.web_demo.entity.Category;
import com.example.web_demo.entity.Product;
import com.example.web_demo.repository.ProductRepository;
import com.example.web_demo.rules.ProductBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class ProductService {

    // repository bağımlılığı
    // final: yalnızca construvtor üzerinden set edilebilir olması için
    private final ProductRepository productRepository;
    private final ProductBusinessRules productBusinessRules;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ProductBusinessRules productBusinessRules, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productBusinessRules = productBusinessRules;
        this.categoryService = categoryService;
    }

    public CreatedProductResponse add(@Valid CreateProductRequest createProductRequest) {
        // Business rules
        // Aynı isimden bir ürün daha eklememeli
        // İlgili kategori id ile bir kategori bulunmadığında hata fırlat
        // İş kuralları en üste yazılır ki hata fırlattığında işlem biter

        productBusinessRules.productMustNotExistWithSameName(createProductRequest.getName());

        // CategoryService'e bize verilen categoryId ile bir kategori bulmaya çalış,
        // bulamazsan hata fırlat
        Category category = categoryService.findCategoryById(createProductRequest.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Bu id ile bir kategori bulunamadı."));
        // hata fırlatırsa alt satırlara geçmeyeceği için if-else ihtiyyacı yok
        category.setId(createProductRequest.getCategoryId());

        Product product = new Product();

        product.setName(createProductRequest.getName());
        product.setUnitPrice(createProductRequest.getUnitPrice());
        product.setStock(createProductRequest.getStock());
        product.setDescription(createProductRequest.getDescription());



        product.setCategory(category);
        productRepository.save(product);
        return new CreatedProductResponse(product.getId(),
                product.getName(),
                product.getStock(),
                product.getDescription(),
                product.getUnitPrice(),
                category.getName());
    }

    public void update(){
    //productMustNotExistWithSameName();
    }

    public GetByIdProductResponse getById(int id){
        Product product = productRepository.findById(id).orElseThrow(()-> new NotFoundException("Bu id ile bir ürün bulunamadı."));

        // manuel mapping
        return new GetByIdProductResponse(product.getId(),
                product.getName(),
                product.getStock(),
                product.getDescription(),
                product.getUnitPrice(),
                product.getCategory().getId(),
                product.getCategory().getName());
    }

    public List<SearchProductResponse> search(SearchProductRequest request){
        List<Product> productList = productRepository.search("%"+request+"%");

        List<SearchProductResponse> responseList = new ArrayList<>();

        for (Product product:productList){
            SearchProductResponse response = new SearchProductResponse();
            response.setId(product.getId());
            response.setCategoryId(product.getId());
            response.setCategoryName(product.getCategory().getName());
            response.setDescription(product.getDescription());
            response.setName(product.getName());

            responseList.add(response);
        }
        return responseList;
    }


}
