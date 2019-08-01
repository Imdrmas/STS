package com.issamdrmas.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.issamdrmas.model.OrderMovie;
import com.issamdrmas.model.OrderProduct;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);

}