package com.userRegistration.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("user_profile")
public class User {
	
	@Id
	public String loginId;
	@NotNull
	public String firstName;
	@NotNull
	public String lastName;
	@NotNull
	public String email;
	@NotNull
	public String password;
	@NotNull
	public String confirmPassword;
	@NotNull
	public String contactNo;
	
	public boolean isLocked;
	public boolean isAdmin;
	

}
