package com.issamdrmas.impl;


import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issamdrmas.dao.ProductRepository;
import com.issamdrmas.model.Product;
import com.issamdrmas.services.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		productRepository.deleteById(id);
		return new ResponseEntity<String>("Product has been deleted!", HttpStatus.OK);
	}

	@Override
	public Product getById(Long id) {
		Optional<Product> optionalPOptional = productRepository.findById(id);
		if (optionalPOptional.isPresent()) {
			Product product = optionalPOptional.get();
			return product;
		}
		return null;
	}
}

