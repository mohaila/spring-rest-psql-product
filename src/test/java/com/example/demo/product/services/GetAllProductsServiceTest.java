package com.example.demo.product.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.demo.product.entities.Product;
import com.example.demo.product.repositories.ProductRepository;

public class GetAllProductsServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private GetAllProductsService getAllProductsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductServiceWhenProductsExist() {
        Product product1 = new Product(
                1,
                "Product 1",
                "Product 1 awesome description",
                0.99);
        Product product2 = new Product(
                2,
                "Product 2",
                "Product 2 awesome description",
                1.99);
        final List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        when(productRepository.findAll()).thenReturn(products);

        ResponseEntity<List<Product>> response = getAllProductsService.execute(null);

        assertEquals(ResponseEntity.ok(products), response);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetAllProductsServiceWhenNoProducts() {
        final List<Product> products = new ArrayList<Product>();
        when(productRepository.findAll()).thenReturn(products);

        ResponseEntity<List<Product>> response = getAllProductsService.execute(null);

        assertEquals(ResponseEntity.ok(products), response);
        verify(productRepository, times(1)).findAll();
    }
}
