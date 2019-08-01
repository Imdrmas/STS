package com.dvd.ecommerce.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.ecommerce.model.Order;
import com.dvd.ecommerce.repository.OrderRepository;
import com.dvd.ecommerce.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public @NotNull Iterable<Order> getAllOrders() {
		return this.orderRepository.findAll();
	}

	@Override
	public Order create(@NotNull(message = "The order cannot be null.") @Valid Order order) {
		return this.orderRepository.save(order);
	}

	@Override
	public void update(@NotNull(message = "The order cannot be null.") @Valid Order order) {
		this.orderRepository.save(order);
		
	}

}
