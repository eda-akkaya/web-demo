package com.example.web_demo.repository;

import com.example.web_demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository -> ORM tool'unun, ilgili nesnenin (tablo) üzerinde işlem yapabilmesini sağlayan nesne
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
