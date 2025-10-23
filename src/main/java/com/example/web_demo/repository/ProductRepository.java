package com.example.web_demo.repository;

import com.example.web_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


// JpaRepository -> ORM tool'unun, ilgili nesnenin (tablo) üzerinde işlem yapabilmesini sağlayan nesne
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // select * from products where name LIKE '%%'
    // derived query methods -> basit işler için kullanılıyor
    // SELECT * FROM PRODUCTS WHERE name LIKE '{name}'
    List<Product> findByNameLikeIgnoreCase(String name);

    //native query -> saf sql
    // native query=? false -> JPQL
    //NATİVE QUERY= true ->  saf SQL
    @Query(value="SELECT p FROM Product p WHERE UPPER(p.name) LIKE UPPER(:name)", nativeQuery = false)
    List<Product> search(String name);

    @Query(value="SELECT * FROM Product p WHERE LIKE UPPER(:name)", nativeQuery = true)
    List<Product> searchSql(String name);

    // Optional: sonuç bulunmayabilir
    Optional<Product> findTop1ByNameIgnoreCase(String name);


}
