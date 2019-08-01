package com.issamdrmas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.issamdrmas.model.OrderProduct;
import com.issamdrmas.model.OrderProductPK;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {


}
