package com.newproject.newolaversion.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproject.newolaversion.model.Car;
import com.newproject.newolaversion.model.Driver;
import com.newproject.newolaversion.model.DriverWithCar;
import com.newproject.newolaversion.repository.CarRepository;
import com.newproject.newolaversion.repository.DriverRepository;
import com.newproject.newolaversion.repository.DriverWithCarRepository;
import com.newproject.newolaversion.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService{

	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private DriverWithCarRepository userWithCarRepository;
	
	@Autowired
	private CarRepository carOwnerRepository;

	public Map<String, Object> driverRegister(Driver driver) {
 			
			
			Map<String, Object> response = new HashMap<String, Object>();
			Date date= new Date();
 
	 		Driver email=driverRepository.findByEmail(driver.getEmail());
			Driver contactNuber=driverRepository.findByContactNumber(driver.getContactNumber());

			if(contactNuber != null){
				response.put("msg", "duplicate contactNuber");
			}
			else if(email!=null){
				response.put("msg", "duplicate emailid");
			}else
			{
				driver.setDate(date);
				driver.setCreatedAt(date);
				driver.setUpdatedAt(date);
				//userRegistration.setPassword(bCryptPasswordEncoder.encode(userRegistration.getPassword()));
	 			response.put("driver saved Data", driverRepository.save(driver));
			    response.put("msg", " Driver registered sucessfully");
			}
	 		return response;
		}

	public Map<String, Object> OneLogInForAll(String email, String password) {
		Map<String, Object> response = new HashMap<String, Object>();
 		
		 
		if (email != null) {
			Car carowner = carOwnerRepository.findByCarOwnerEmail(email);
			Driver d=driverRepository.findByEmail(email);

			if (carowner != null && carowner.getCarOwnerPassword().toString().equals(password)) {
		            carowner.setCarOwnerPassword(null);
					response.put("msg", "carowner login succesful");
					response.put("status",1);
                    response.put("detail", carowner);
				} else if(d !=null  && d.getPassword().toString().equals(password)) {
		            d.setPassword(null);
					response.put("msg", "driver login succesful by phone number");
					response.put("status",1);
                    response.put("detail", d);
                    } 
 				else  {
			    DriverWithCar dr=userWithCarRepository.findByEmail(email);
			    if(dr !=null  && dr.getPassword().toString().equals(password)) {
		            dr.setPassword(null);
					response.put("msg", "driverwithcar login succesful");
					response.put("status",1);

					response.put("detail", dr);
				
				} else
					response.put("msg", "please check currect email password");
		}
 
		}
		return response;
	}

	@Override
	public List<Driver> checkStatus(String status) {
		 return driverRepository.findByStatus(status);
	}

	 
 }
