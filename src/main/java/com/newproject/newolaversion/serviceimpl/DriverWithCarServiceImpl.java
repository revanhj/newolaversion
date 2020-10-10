package com.newproject.newolaversion.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.newproject.newolaversion.model.DriverWithCar;
import com.newproject.newolaversion.repository.DriverWithCarRepository;
import com.newproject.newolaversion.service.DriverWithCarService;

@Service
public class DriverWithCarServiceImpl implements DriverWithCarService{

	
	@Autowired
	private DriverWithCarRepository driverWithCarrepository;

	@Override
	public List<DriverWithCar> getStatus(String status) {
		// TODO Auto-generated method stub
		return driverWithCarrepository.findByStatus(status);
	}
	
	
	 
}
