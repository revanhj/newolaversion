package com.newproject.newolaversion.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.newolaversion.model.User;
import com.newproject.newolaversion.service.UserRegistrationService;
import com.newproject.newolaversion.serviceimpl.UserRegistrationServiceImpl;

@RestController
@RequestMapping(value = "user")
public class UserRegistrationController {

	
	
	@Autowired
	private UserRegistrationService userregistrationService;
	
	
	@Autowired
	private UserRegistrationServiceImpl userRegistrationServiceImpl;
	
	
	@PostMapping("/add")
	public Map<String, Object> userRegistred(@RequestBody User user){
		System.out.println("hiiiiiiiiiiiiii");
		return userregistrationService.UserRegistration(user);
		
	}
	
	
	@RequestMapping(value = "/login/{email}/{password}",method = RequestMethod.POST,produces = "application/json")
	public Map<String, Object> allInOneLogIn(@PathVariable String email, @PathVariable String password){
		return userregistrationService.allInOneLogIn(email, password);
		
	}
}
