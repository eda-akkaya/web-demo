package com.example.web_demo.repository;

import com.example.web_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// JpaRepository -> ORM tool'unun, ilgili nesnenin (tablo) üzerinde işlem yapabilmesini sağlayan nesne
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // select * from products where name LIKE '%%'
    // derived query methods
    // SELECT * FROM PRODUCTS WHERE name LIKE '{name}'
    List<Product> findByNameLikeIgnoreCase(String name);

    //native query -> saf sql
    // native query=? false -> JPQL
    //NATİVE QUERY= true -> SQL
    @Query(value="SELECT p FROM Product p WHERE LIKE %UPPER(p.name)%", nativeQuery = false)
    List<Product> search(String name);




}
