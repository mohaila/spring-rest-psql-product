package com.example.demo.product.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super(Messages.ProductNotFound.getMessage());
    }
}
