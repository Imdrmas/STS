package com.issamdrmas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.CustomerRepository;
import com.issamdrmas.model.Customer;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/")
	private String home() {
		return "Welcome to home page";
	}
	@GetMapping("/user")
	private String user() {
		return "Welcome to user page";
	}
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		System.out.println("Get all customers...");
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	@PostMapping(value = "/customers/create")
	public Customer create(@RequestBody Customer customer) {
		Customer _Customer = customerRepository.save(
				new Customer(customer.getName(), customer.getEmail(), customer.getAddress(), customer.getAge(), customer.getPhone()));
		return _Customer;
	}
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
		System.out.println("Delete customer with ID = "+ id + "...");
		customerRepository.deleteById(id);
		return new ResponseEntity<String>("Customer has been deleted!", HttpStatus.OK);
	}
	@DeleteMapping("/customers/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");
		customerRepository.deleteAll();
		return new ResponseEntity<String>("All customer have been deleted!", HttpStatus.OK);
	}
	@GetMapping(value = "customers/age/{age}")
	public List<Customer> findByAge(@PathVariable int age){
		List<Customer> customers = customerRepository.findByAge(age);
		return customers;
	}
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> update(@PathVariable("id") Long id, @RequestBody Customer customer){
		System.out.println("Update customer with id = " + id + "....");
		Optional<Customer> customerDataOptional = customerRepository.findById(id);
		if (customerDataOptional.isPresent()) {
			Customer _Customer = customerDataOptional.get();
			_Customer.setName(customer.getName());
			_Customer.setAge(customer.getAge());
			_Customer.setActive(customer.isActive());
			return new ResponseEntity<Customer>(customerRepository.save(_Customer), HttpStatus.OK);
		}else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}


}
