package com.issamdrmas.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.issamdrmas.model.Movie;
import java.lang.String;

public interface MovieRepositpry extends MongoRepository<Movie, String>{
	
     List<Movie> findBy_id(String _id); 

	@Query("{title : ?0}")
	Movie findByTitleQuery(String title);
	
	@Query("{_id : ?0}")
	Movie findBy_idQuery(String _id);
	
	@Query("{year : ?0}")
	List<Movie> findByYear(int year);
	
	@Query(value = "{'director._id' : ?0}")
	List<Movie> findDirectorBy_id(String _id);
	
	@Query(value = "{'actors._id' : ?0}")
	List<Movie> findActorsBy_id(String _id);
	
	@Query("{title : {$regex : ?0}}")
	List<Movie> findByTitle(String title);
	
	@Query("{'year' : {$gt : ?0, $lt : ?1}}")
	List<Movie> findMovieBetweenQuery(int start, int end);


}
