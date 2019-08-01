package com.issamdrmas.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.issamdrmas.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);
    
    public ResponseEntity<String> deleteById(Long id);
    
    public Product getById(Long id);
}