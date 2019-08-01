package com.issamdrmas.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issamdrmas.dao.OrderRepository;
import com.issamdrmas.model.Order;
import com.issamdrmas.model.OrderMovie;
import com.issamdrmas.services.OrderService;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }


}