package com.greatlearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfiguration {
	
	@Autowired //here is confiure related to spirng boot basic authenitciation
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("zone").password("{noop}password").roles("USER") //noop is for ploain text
		.and()
		.withUser("zone3").password("{noop}password").roles("USER");
	}
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		
		.httpBasic()  //it indicates basic auth is requiores
		.and()
		.authorizeRequests()
		.antMatchers("/index").permitAll() //index will accesible dirctly no need of any authentication
		.anyRequest().authenticated(); //its indicates all request will be secure
		
		http.csrf().disable(); // to disable csrf
	}
	
	
}
