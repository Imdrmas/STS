package com.dvd.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dvd.ecommerce.model.Product;

public interface SearchRepository extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);
}
