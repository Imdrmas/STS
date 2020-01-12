package com.issamdrmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguaration extends WebSecurityConfigurerAdapter {
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	 http.authorizeRequests()
	 		.antMatchers("/hello*").access("hasRole('ROLE_ADMIN')").and().formLogin();;
	    }
	 
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	 auth.inMemoryAuthentication().withUser("java2blog").password("java123").roles("ADMIN");
	    }

}
