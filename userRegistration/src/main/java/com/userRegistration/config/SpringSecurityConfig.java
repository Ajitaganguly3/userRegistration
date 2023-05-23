package com.userRegistration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.userRegistration.service.UserProfileService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{
	
	@Autowired
	UserProfileService userProfileService;
	
	com.userRegistration.model.User userModel;
	
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http
				.authorizeExchange()
				.pathMatchers("/register", "/login").permitAll()
				.pathMatchers("/validate", "/swagger-ui.html", "/swagger-ui/**", "/v2/api-docs").permitAll()
				.pathMatchers("/admin/**").hasRole("ADMIN")
				.pathMatchers("/users/**").hasRole("USER")
				.anyExchange().authenticated()
				.and()
				.csrf().disable()
				.httpBasic()
				.and()
				.build();
	}
	 
	 @Bean
		public InMemoryUserDetailsManager userDetailService(PasswordEncoder passwordEncoder) {
			UserDetails user = User.withUsername(userModel.getLoginId())
					.password(passwordEncoder.encode(userModel.getPassword()))
					.roles("USER")
					.build();
			
			UserDetails admin = User.withUsername(userModel.getLoginId())
					.password(passwordEncoder.encode(userModel.getPassword()))
					.roles("ADMIN")
					.build();
			
			return new InMemoryUserDetailsManager(user, admin);
		}

}
