package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.issamdrmas.model.Restaurant;
import java.lang.String;


public interface RestaurantDao extends MongoRepository<Restaurant, String> {

	@Query("{restaurant_id : ?0}")
	List<Restaurant> findRestaurant_id(String restaurant_id);

	@Query("{borough : ?0}")
	List<Restaurant> findBorough(String borough);

	@Query("{cuisine : ?0}")
	List<Restaurant> findCuisine(String cuisine);

    List<Restaurant> findByName(String name);
	
	List<Restaurant> findByAddressZipcode(String zipCode);


}
