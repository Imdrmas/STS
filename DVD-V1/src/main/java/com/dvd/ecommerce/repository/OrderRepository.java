package com.dvd.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvd.ecommerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
