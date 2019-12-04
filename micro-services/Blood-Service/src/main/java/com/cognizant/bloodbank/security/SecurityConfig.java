package com.cognizant.bloodbank.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
	/*	httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/authenticate").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers("/users").permitAll().antMatchers(HttpMethod.POST, "/**").permitAll()
		.antMatchers("/authenticate").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
		.and().addFilter(new JwtAuthorizationFilter(authenticationManager()));*/
		
		 httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()/*.antMatchers("/movies").permitAll()
         .antMatchers("/users").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
          .authenticated()*/
		 .antMatchers("/usersignup").permitAll().antMatchers(HttpMethod.POST, "/**").permitAll()
		 .antMatchers("/slotbooking").permitAll().antMatchers(HttpMethod.POST, "/**").permitAll()
		 .antMatchers("/experience").permitAll().antMatchers(HttpMethod.POST, "/**").permitAll()
		 .antMatchers("/bloodrequire").permitAll().antMatchers(HttpMethod.GET, "/**").permitAll()
		 .antMatchers("/query").permitAll().antMatchers(HttpMethod.POST, "/**").permitAll()
		 .antMatchers("/authenticate").permitAll().antMatchers(HttpMethod.OPTIONS, "/**")
         .permitAll().anyRequest().authenticated().and()
         .addFilter(new JwtAuthorizationFilter(authenticationManager()));
		 
	}
	
}
