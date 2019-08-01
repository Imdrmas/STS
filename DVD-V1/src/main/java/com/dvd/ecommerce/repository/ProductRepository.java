package com.dvd.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvd.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
