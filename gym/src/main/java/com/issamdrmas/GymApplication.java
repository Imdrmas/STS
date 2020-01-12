package com.issamdrmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.issamdrmas.dao.GymnasesRepository;


@SpringBootApplication
public class GymApplication implements CommandLineRunner {
	
	@Autowired
	GymnasesRepository gymnasesRepository;

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
		System.out.println("App started successfully ...");
	}

	        
	@Override
	public void run(String... args) throws Exception {
	//	gymnasesRepository.deleteAll();
		
	//	gymnasesRepository.save(new Gymnases(20, "Drmas", "1 Rue de paris", "Paris", 300, null));
		
	}

}
