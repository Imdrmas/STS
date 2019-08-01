package com.dvd.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.ecommerce.model.Product;
import com.dvd.ecommerce.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	ProductService productService;
	
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}



	@GetMapping(value= {"", "/"})
	public @NotNull Iterable<Product> getProducts(){
		return productService.getAllProducts();
	}

}
