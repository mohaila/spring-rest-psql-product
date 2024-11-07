package com.example.demo.product.services;

import com.example.demo.product.entities.Product;
import com.example.demo.product.exceptions.ProductNotFoundException;

import java.util.Optional;
import com.example.demo.product.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private GetProductService getProductService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductServiceWhenProductExists() {
        Product product = new Product(
                1,
                "Product 1",
                "Product awesome description",
                0.99);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        ResponseEntity<Product> response = getProductService.execute(1);

        assertEquals(ResponseEntity.ok(product), response);
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void testGetProductServiceWhenProductNotFound() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productRepository, times(1)).findById(1);
    }

}
