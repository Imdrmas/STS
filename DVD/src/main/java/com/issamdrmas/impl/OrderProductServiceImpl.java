package com.issamdrmas.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issamdrmas.dao.OrderProductRepository;
import com.issamdrmas.model.OrderMovie;
import com.issamdrmas.model.OrderProduct;
import com.issamdrmas.services.OrderProductService;


@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    private OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }


}