package com.example.web_demo.rules;

import com.example.web_demo.Core.exception.type.BusinessException;
import com.example.web_demo.entity.Product;
import com.example.web_demo.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductBusinessRules {

    private final ProductRepository productRepository;

    public ProductBusinessRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void productMustNotExistWithSameName(String name){
        Product productWithSameName = productRepository
                .findTop1ByNameIgnoreCase(name)
                .orElse(null);

        if (productWithSameName != null)
            throw new BusinessException("bu isim ile bir ürün zaten bulunmaktadır");

    }
}
