package com.example.demo.product.services;

import com.example.demo.product.entities.Product;
import com.example.demo.product.repositories.ProductRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SearchProductService implements Query<String, List<Product>> {
    private final ProductRepository productRepository;

    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> execute(String param) {
        List<Product> products = productRepository.findByNameLike(param);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}
