package com.dvd.ecommerce.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.ecommerce.model.OrderProduct;
import com.dvd.ecommerce.repository.OrderProductRepository;
import com.dvd.ecommerce.service.OrderProductService;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService{
	
	private OrderProductRepository orderProductRepository;
	
	public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
		this.orderProductRepository = orderProductRepository;
	}

	@Override
	public OrderProduct create(
			@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct) {
		return this.orderProductRepository.save(orderProduct);
	}

}
