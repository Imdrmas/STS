package com.dvd.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import com.dvd.ecommerce.model.Product;

@Validated
public interface ProductService {

	@NotNull
	List<Product> getAllProducts();
	
	Product getProduct(Long id);
	
	Product save(Product product);

	Optional<Product> findById(Long productId);

	void deleteById(Long productId);



}
