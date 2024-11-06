package com.example.demo.product.commands;

import com.example.demo.product.entities.Product;

import lombok.Data;

@Data
public class UpdateProduct {
    private final Integer id;
    private final String name;
    private final String description;
    private final Double price;

    public Product toEntity() {
        return new Product(id, name, description, price);
    }
}
