package com.example.demo.product.exceptions;

public enum Messages {
    ProductNotFound("Product not found");

    private final String message;

    public String getMessage() {
        return message;
    }

    private Messages(String message) {
        this.message = message;
    }
}
