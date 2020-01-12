package com.issamdrmas.dao;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.issamdrmas.model.Gymnases;
@Repository
public interface GymnasesRepository extends MongoRepository<Gymnases, Integer> {
	
	List<Gymnases> findByIdGymnase(int idGymnase);

	List<Gymnases> findByNomGymnase(String nomGymnase);

	List<Gymnases> findByVille(String Ville);
	
	@Query(value = "{'Seances.Libelle' : ?0}")
	List<Gymnases> findSeanceByLibelle(String libelle);
	
	@Query("{'Seances.Jour' : ?0}")
	List<Gymnases> findSeanceByJour(String jour);
	
	@Query("{'Seances.Horaire' : ?0}")
	List<Gymnases> findSeanceByHoraire(int horiare);

	List<Gymnases> findBySurface(int surface);
}
