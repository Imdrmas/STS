package com.issamdrmas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issamdrmas.model.SuperMarket;

public interface SuperMarketDao extends JpaRepository<SuperMarket, Integer> {

}
