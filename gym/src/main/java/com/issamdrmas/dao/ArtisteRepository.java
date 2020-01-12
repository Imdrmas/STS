package com.issamdrmas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.issamdrmas.model.Artiste;

public interface ArtisteRepository extends MongoRepository<Artiste, Integer> {

}
