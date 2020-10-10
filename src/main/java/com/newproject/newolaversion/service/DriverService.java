package com.newproject.newolaversion.service;

import java.util.List;
import java.util.Map;

import com.newproject.newolaversion.model.Driver;

public interface DriverService {

	public Map<String, Object> driverRegister(Driver driver);
	public Map<String, Object> OneLogInForAll(String email, String password);
	public List<Driver> checkStatus(String status);

 
 }
