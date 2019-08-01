package com.grokonez.jwtauthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.repository.RoleRepository;



@SpringBootApplication
public class SpringBootJwtAuthenticationApplication implements CommandLineRunner {
	
	//@Autowired
	//private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//User admin = new User("admin", "drmas", "drmas@gmail.com", "password");
		//User user = new User("user", "issam", "issam@gmail.com", "password");
		//userRepository.save(admin);
		//userRepository.save(user);
		
		Role adminRole = new Role(RoleName.ROLE_ADMIN);
		Role useRole = new Role(RoleName.ROLE_USER);
		Role pmRole = new Role(RoleName.ROLE_PM);
	
		roleRepository.save(adminRole);
		roleRepository.save(useRole);
		roleRepository.save(pmRole);
		
	}
}
