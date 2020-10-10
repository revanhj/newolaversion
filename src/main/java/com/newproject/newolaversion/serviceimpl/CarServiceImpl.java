package com.newproject.newolaversion.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproject.newolaversion.model.Car;
import com.newproject.newolaversion.repository.CarRepository;
import com.newproject.newolaversion.service.CarService;


@Service
public class CarServiceImpl implements CarService{
	
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> checkStatus(String status) {
 		return carRepository.findByStatus(status);
	}
	
}
