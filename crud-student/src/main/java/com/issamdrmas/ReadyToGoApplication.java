package com.issamdrmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.issamdrmas.dao.StudentDao;
import com.issamdrmas.model.Student;


@SpringBootApplication
public class ReadyToGoApplication implements CommandLineRunner  {
	
	@Autowired
	StudentDao service;
	

	public static void main(String[] args) {
		SpringApplication.run(ReadyToGoApplication.class, args);
		System.out.println("\n---------------------------");
		System.out.println("App Started Successfully ...");
	
	
    }

	@Override
	public void run(String... args) throws Exception {
		service.save(new Student("Drmas", "Issam", "Programmer"));
		service.save(new Student("Rasha", "Adem", "Lower"));
		service.save(new Student("Nini", "Hassabo", "Doctor"));
		
	}
}