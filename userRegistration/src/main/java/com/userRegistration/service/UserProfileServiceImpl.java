package com.userRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.userRegistration.model.User;
import com.userRegistration.repository.LoginRepository;
import com.userRegistration.util.JWTUtil;

@Service
public class UserProfileServiceImpl {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetails userDetails;
	
	public String getUserByLoginId(String loginId, String password) {
		
		java.util.Optional<User> userOptional = loginRepository.findByLoginId(loginId);
		
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			
			if(!passwordEncoder.matches(password, user.getPassword())) {
				return null;
			}
			
			if(user.isLocked()) {
				return null;
			}
			
			String token = jwtUtil.generateToken(userDetails);
			
			System.out.println("JWT Token: " + token);
			
			System.out.println("end generateToken");
			
			return token;
		}
		return null;
	}

}
