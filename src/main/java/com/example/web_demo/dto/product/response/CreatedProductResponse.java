package com.example.web_demo.dto.product.response;

public class CreatedProductResponse {

    private int id;
    private String name;
    private float stock;
    private String desciption;
    private float unitPrice;

    public CreatedProductResponse(int id, String name, float stock, String desciption, float unitPrice) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.desciption = desciption;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
