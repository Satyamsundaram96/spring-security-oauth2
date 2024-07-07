package com.spring_security_oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class GitHubSecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests( authorizeRequests -> authorizeRequests
				.requestMatchers("/home").permitAll()
				.anyRequest().authenticated())
		.oauth2Login(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
		//.formLogin(formLogin -> formLogin.loginPage("/login").permitAll() // For Custom Login page
		return http.build();
	}
}
