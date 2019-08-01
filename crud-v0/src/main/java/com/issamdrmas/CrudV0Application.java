package com.issamdrmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudV0Application implements CommandLineRunner {
	
	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudV0Application.class, args);
		System.out.println("\n---------------------------");
		System.out.println("App Started Successfully ...");    		
		
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1 = new Customer("issam", "drmas", 30, true);
		Customer c2 = new Customer("Rasha", "Adem", 18, false);
		Customer c3 = new Customer("Fatima", "Hassan", 22, true);
		Customer c4 = new Customer("Mohand", "Abdallah", 20, false);
		
		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		customerRepository.save(c4);
	}
 
}