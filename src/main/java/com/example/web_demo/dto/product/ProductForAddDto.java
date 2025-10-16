package com.example.web_demo.dto.product;

public class ProductForAddDto {
    private String name;
    private String description;
    private float stock;
    private float unitPrice;
    private int categoryId;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getStock() {
        return stock;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
