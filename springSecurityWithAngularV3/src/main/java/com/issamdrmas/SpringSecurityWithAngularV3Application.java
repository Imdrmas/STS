package com.issamdrmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.issamdrmas.entities.Role;
import com.issamdrmas.entities.User;
import com.issamdrmas.model.RoleName;
import com.issamdrmas.repository.RoleRepository;
import com.issamdrmas.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityWithAngularV3Application implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithAngularV3Application.class, args);
		System.out.println("\n---------------------------");
		System.out.println("App Started Successfully ...");	
	}

	@Override
	public void run(String... args) throws Exception {
		User admin = new User("admin", "drmas", "drmas@gmail.com", "password");
		User user = new User("user", "issam", "issam@gmail.com", "password");
		userRepository.save(admin);
		userRepository.save(user);
		
		Role adminRole = new Role(RoleName.ROLE_ADMIN);
		Role useRole = new Role(RoleName.ROLE_USER);
		Role pmRole = new Role(RoleName.ROLE_PM);
		
		roleRepository.save(adminRole);
		roleRepository.save(useRole);
		roleRepository.save(pmRole);
		
	}
}