package com.issamdrmas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.model.Product;
import com.issamdrmas.services.ProductService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") long id) {
		return productService.getById(id);
	}

    @GetMapping("/products")
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/products")
    public Product createMovie(@Valid @RequestBody Product product) {
    	return productService.save(product);
    }
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		return productService.deleteById(id);
	}
}