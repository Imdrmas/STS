package com.dvd.ecommerce.service;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.dvd.ecommerce.model.Product;

@Validated
public interface ProductService {

	@NotNull
	Iterable<Product> getAllProducts();
	
	Product getProduct(Long id);
	
	Product save(Product product);


}
