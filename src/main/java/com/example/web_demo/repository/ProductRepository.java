package com.example.web_demo.repository;

import com.example.web_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository -> ORM tool'unun, ilgili nesnenin (tablo) üzerinde işlem yapabilmesini sağlayan nesne
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
