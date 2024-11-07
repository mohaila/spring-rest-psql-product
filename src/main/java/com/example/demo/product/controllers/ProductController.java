package com.example.demo.product.controllers;

import com.example.demo.product.commands.CreateProduct;
import com.example.demo.product.commands.UpdateProduct;
import com.example.demo.product.entities.Product;
import com.example.demo.product.services.CreateProductService;
import com.example.demo.product.services.DeleteProductService;
import com.example.demo.product.services.GetAllProductsService;
import com.example.demo.product.services.GetProductService;
import com.example.demo.product.services.SearchProductService;
import com.example.demo.product.services.UpdateProductService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final GetAllProductsService getAllProductsService;
    private final GetProductService getProductService;
    private final CreateProductService createProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;
    private final SearchProductService searchProductService;

    public ProductController(
            GetAllProductsService getAllProductsService,
            GetProductService getProductService,
            CreateProductService createProductService,
            UpdateProductService updateProductService,
            DeleteProductService deleteProductService,
            SearchProductService searchProductService) {
        this.getAllProductsService = getAllProductsService;
        this.getProductService = getProductService;
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.searchProductService = searchProductService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return getAllProductsService.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return getProductService.execute(id);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody CreateProduct param) {
        Product product = param.toEntity();
        return createProductService.execute(product);
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@Valid @RequestBody UpdateProduct param) {
        Product product = param.toEntity();
        return updateProductService.execute(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return deleteProductService.execute(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name) {
        return searchProductService.execute(name);
    }
}
