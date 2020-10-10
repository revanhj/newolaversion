package com.newproject.newolaversion.service;

import java.util.Map;

import com.newproject.newolaversion.model.User;
 
public interface UserRegistrationService {

	
	public Map<String, Object> UserRegistration(User user);
	public Map<String, Object> allInOneLogIn(String email, String password);
}
