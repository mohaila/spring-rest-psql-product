package com.example.demo.product.services;

import com.example.demo.product.exceptions.ProductNotFoundException;
import com.example.demo.product.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService implements Command<Integer, Void> {
    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer param) {
        if (productRepository.findById(param).isPresent()) {
            productRepository.deleteById(param);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        throw new ProductNotFoundException();
    }

}
