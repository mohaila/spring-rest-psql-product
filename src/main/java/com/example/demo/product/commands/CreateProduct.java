package com.example.demo.product.commands;

import com.example.demo.product.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateProduct {
    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    @NotBlank(message = "Name is required")
    private final String name;
    @Size(min = 20, message = "Description must be at least 20 characters")
    private final String description;
    @Positive(message = "Price must be positive")
    private final Double price;

    public Product toEntity() {
        return new Product(null, name, description, price);
    }

}
