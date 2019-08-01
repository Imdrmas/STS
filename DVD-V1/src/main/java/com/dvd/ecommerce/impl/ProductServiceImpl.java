package com.dvd.ecommerce.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.ecommerce.exception.ResourceNotFoundException;
import com.dvd.ecommerce.model.Product;
import com.dvd.ecommerce.repository.ProductRepository;
import com.dvd.ecommerce.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	private
	ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	  @Override
	    public Iterable<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	


}
