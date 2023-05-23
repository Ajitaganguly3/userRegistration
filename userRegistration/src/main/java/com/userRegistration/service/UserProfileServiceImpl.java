package com.userRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.userRegistration.dto.UserProfileDTO;
import com.userRegistration.model.User;
import com.userRegistration.repository.LoginRepository;

@Service
public class UserProfileServiceImpl {
	
	@Autowired
	private LoginRepository loginRepository;
	
	
	public UserProfileDTO getUserByLoginId(String loginId) {
		
		User user = loginRepository.findByLoginId(loginId);
		
		if(user == null) {
			System.out.println("User not found: " + loginId);
		
		}
		else {
			System.out.println("User found: " + user.getLoginId());
			return transformIntoUserEntity(user);
		}
		return null;		
	}
	
	private UserProfileDTO transformIntoUserEntity(User user) {
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		userProfileDTO.setLoginId(user.getLoginId());
		userProfileDTO.setFirstName(user.getFirstName());
		userProfileDTO.setLastName(user.getLastName());
		userProfileDTO.setPassword(user.getPassword());
		userProfileDTO.setConfirmPassword(user.getConfirmPassword());
		userProfileDTO.setEmail(user.getEmail());
		userProfileDTO.setContactNo(user.getContactNo());
		
		return userProfileDTO;
	}

}
