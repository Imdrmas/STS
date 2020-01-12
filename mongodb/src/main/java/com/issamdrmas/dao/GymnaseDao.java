package com.issamdrmas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.issamdrmas.model.Gymnases;

public interface GymnaseDao extends MongoRepository<Gymnases, Integer>{

}
