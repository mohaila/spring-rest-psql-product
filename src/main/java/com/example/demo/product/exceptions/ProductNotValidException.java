package com.example.demo.product.exceptions;

public class ProductNotValidException extends RuntimeException {
    public ProductNotValidException(String message) {
        super(message);
    }
}
