package com.dvd.ecommerce.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	    public List<Product> getAllProducts() {
	        List<Product> list = productRepository.findAll();
	        List<Product> sortedList = list.stream()
	        		.sorted(Comparator.comparing(Product::getId).reversed())
	        		.collect(Collectors.toList());
	        return sortedList;
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

	@Override
	public Optional<Product> findById(Long productId) {
		return productRepository.findById(productId);
	}

	@Override
	public void deleteById(Long productId) {
		productRepository.deleteById(productId);
	}

	


}
