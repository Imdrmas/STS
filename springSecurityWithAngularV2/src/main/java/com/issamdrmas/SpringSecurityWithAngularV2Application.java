package com.issamdrmas;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


@SpringBootApplication
public class SpringSecurityWithAngularV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithAngularV2Application.class, args);
		System.out.println("\n---------------------------");
		System.out.println("App Started Successfully ...");

		
	}
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("OPTIONS");
		configuration.addAllowedMethod("POST");
		configuration.addAllowedMethod("GET");
		configuration.addAllowedMethod("PUT");
		configuration.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", configuration);
		return new CorsFilter();

	}

}
