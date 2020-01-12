package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.issamdrmas.model.Sportifs;

public interface SportifsRepository extends MongoRepository<Sportifs, Integer> {

	List<Sportifs> findByIdSportif(int idSportif);

	List<Sportifs> findBySexe(String sexe);

}
