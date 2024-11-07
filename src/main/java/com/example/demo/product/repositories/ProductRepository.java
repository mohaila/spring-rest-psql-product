package com.example.demo.product.repositories;

import com.example.demo.product.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE UPPER(p.name) LIKE CONCAT('%', UPPER(:name), '%')")
    List<Product> findByNameLike(@Param("name") String name);
}
