package com.issamdrmas.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.RestaurantDao;
import com.issamdrmas.model.Restaurant;

@RestController
@CrossOrigin(origins = "*")
public class RestaurantController {
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	
	public RestaurantController(RestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}
	@GetMapping("/findAllRestaurants")
	public List<Restaurant> findRestaurants() {
		List<Restaurant> restaurants = restaurantDao.findAll();
		List<Restaurant> soredList = restaurants.stream().sorted(Comparator.comparing(Restaurant::getRestaurant_id)).limit(500)
        .collect(Collectors.toList());
		return soredList;
	}
	
	@GetMapping("/findRestaurantById={restaurant_id}")
	public List<Restaurant> findRestaurantById(@PathVariable("restaurant_id") String restaurant_id) {
		return restaurantDao.findRestaurant_id(restaurant_id);
	}
	@GetMapping("/findAllRestaurants/borough={borough}")
	public List<Restaurant> findRestaurantsBorough(@PathVariable("borough") String borough) {
		return restaurantDao.findBorough(borough);
	}
	
	@GetMapping("/findAllRestaurants/cuisine={cuisine}")
	public List<Restaurant> findRestaurantsCuisine(@PathVariable("cuisine") String cuisine) {
		return restaurantDao.findCuisine(cuisine);
	}
	
	@GetMapping("/findAllRestaurants/Burger-king")
	public List<Restaurant> findRestaurantsGrade() {
		return restaurantDao.findByName("Burger King");
	}
	@GetMapping("/findAllRestaurants/pizza")
	public List<Restaurant> findRestaurantsPizza() {
		return restaurantDao.findCuisine("Pizza");
	}
	
	@GetMapping("/findAllRestaurants/zipcode")
	List<Restaurant> findByAddressZipcode() {
		List<Restaurant> restaurants = restaurantDao.findByAddressZipcode("10001");
		List<Restaurant> soredList = restaurants.stream().sorted(Comparator.comparing(Restaurant::getRestaurant_id)).limit(50)
		        .collect(Collectors.toList());
				return soredList;
	}
	
	@GetMapping("/findAllRestaurants/name={name}")
	public List<Restaurant> findRestaurantsByName(@PathVariable("name") String name) {
		return restaurantDao.findByName(name);
	}

}
