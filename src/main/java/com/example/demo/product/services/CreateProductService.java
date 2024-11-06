package com.example.demo.product.services;

import com.example.demo.product.entities.Product;
import com.example.demo.product.repositories.ProductRepository;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, Void> {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Product param) {
        Product product = productRepository.save(param);
        URI location = URI.create("/api/v1/products/" + product.getId());
        return ResponseEntity.status(HttpStatus.CREATED).location(location).build();
    }
}
