package com.dvd.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.ecommerce.model.Product;
import com.dvd.ecommerce.model.ReplayComment;
import com.dvd.ecommerce.repository.SearchRepository;
import com.dvd.ecommerce.service.ProductService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	ProductService productService;
	
	@Autowired
	private SearchRepository productRepository;
	
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping(value= {"/products", "/"})
	public @NotNull List<Product> getProducts(){
		return productService.getAllProducts();
	}
	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable("id") Long productId) {
	  Optional<Product> products = productService.findById(productId);
	  return products;
	}
	@PostMapping("/products/create")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productService.save(product);
	}
	@PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId, Product product){
	Optional<Product> productOptional = productService.findById(productId);
	if (productOptional.isPresent()) {
		Product product2 = productOptional.get();
		product2.setName(product.getName());
		product2.setDescription(product.getDescription());
		product2.setPrice(product.getPrice());
		product2.setPictureUrl(product.getPictureUrl());
	
		return new ResponseEntity<Product>(productService.save(product2), HttpStatus.OK);
	}
	return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
   }
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long productId) {
		productService.deleteById(productId);
		return new ResponseEntity<String>("Product deleted", HttpStatus.OK);
	}
	@RequestMapping(value="/search/{name}")
	public List<Product> search( @PathVariable String name ) {
		List<Product> products = productRepository.findByName(name);
		return products;
	}


}
