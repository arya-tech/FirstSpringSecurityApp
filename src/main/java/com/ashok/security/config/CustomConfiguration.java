package com.ashok.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomConfiguration {

	/*
	 * @Bean UserDetailsService userDetailsService() { InMemoryUserDetailsManager
	 * userDetailsService = new InMemoryUserDetailsManager(); UserDetails user =
	 * User.withUsername("ashok").password(passwordEncoder().encode("pandit")).
	 * authorities("read") .build(); userDetailsService.createUser(user); return
	 * userDetailsService; }
	 */

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//http.httpBasic();
		http.formLogin();
		http.authorizeHttpRequests().requestMatchers("/hello").authenticated().anyRequest().denyAll();
		return http.build();

	}

}
