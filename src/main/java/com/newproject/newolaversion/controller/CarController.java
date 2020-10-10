package com.newproject.newolaversion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.newolaversion.model.Car;
import com.newproject.newolaversion.serviceimpl.CarServiceImpl;

@RestController
@RequestMapping(value = "car")
public class CarController {

	
	@Autowired
	private CarServiceImpl carServiceImpl;
	
	
	@RequestMapping(value = "/{status}",method = RequestMethod.GET,produces = "application/json")
	public List<Car> getStatus(@PathVariable String status){
		return carServiceImpl.checkStatus(status);
		
	}
}
