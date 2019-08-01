package com.dvd.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvd.ecommerce.model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
