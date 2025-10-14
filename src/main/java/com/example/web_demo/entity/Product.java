package com.example.web_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @Column(name="id") // aynı ismi kullanacaksan gerek yok
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name="unit_price")
    private float price;

    private float stock;

    @Column(name="description")
    private String description;

    //Her product yalnızca bir category'e aittir.
    @ManyToOne // FK hangi tablodaysa OneToMany; diğerine ManyToOne
    @JoinColumn(name="category_id", nullable = true) //daha sonra false yap
    private Category category; //getter-setter'ını da ekle

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
