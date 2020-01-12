package com.issamdrmas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.issamdrmas.model.Seances;

public interface SeancesRepository extends MongoRepository<Seances, Integer> {

}
