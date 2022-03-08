package com.customer.curd;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class CustomerConfiguration extends WebSecurityConfigurerAdapter{
	
	//Adding the roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("praveen")
		.password("123")
		.roles("manager")
		.and()
		.withUser("anil")
		.password("456")
		.roles("customer");
		
	}

	//Configuring the api
	//According to the roles
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/all").hasRole("manager")
		.antMatchers("/add").hasRole("customer")
		.and().formLogin();
				/*
				 * .antMatchers("/add").hasRole("customer")
				 * .antMatchers("/delete/{custId}").hasRole("manager")
				 * .antMatchers("/custId/{custId}").hasRole("customer")
				 * .antMatchers("/search/{name}").hasRole("customer")
				 * .antMatchers("/custId/{custId}").hasRole("manager")
				 * .antMatchers("/search/{name}").hasRole("manager")
				 */
		
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
}
