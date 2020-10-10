package com.newproject.newolaversion.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproject.newolaversion.model.Driver;
import com.newproject.newolaversion.model.User;
import com.newproject.newolaversion.model.DriverWithCar;
import com.newproject.newolaversion.repository.CarRepository;
import com.newproject.newolaversion.repository.DriverRepository;
import com.newproject.newolaversion.repository.UserRegistrationRepository;
import com.newproject.newolaversion.repository.DriverWithCarRepository;
import com.newproject.newolaversion.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	
	@Autowired
	 private UserRegistrationRepository userRegistrationRepository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private DriverWithCarRepository userWithCarRepository;
	
	@Autowired
	 private CarRepository carOwnerRepository;
	

	public Map<String, Object> UserRegistration(User user) {
		Map<String, Object> response = new HashMap<String, Object>();
		Date date= new Date();
        System.out.println("lllllllllllll");
		User email=userRegistrationRepository.findByEmail(user.getEmail());
		User contactNuber=userRegistrationRepository.findByPhoneNo(user.getPhoneNo());

		if(contactNuber != null){
			response.put("msg", "duplicate contactNuber");
		}
		else if(email!=null){
			response.put("msg", "duplicate emailid");
		}else
		{
			user.setDate(date);
			user.setCreatedAt(date);
			user.setUpdatedAt(date);
			//userRegistration.setPassword(bCryptPasswordEncoder.encode(userRegistration.getPassword()));
 			response.put("user saved Data", userRegistrationRepository.save(user));
		    response.put("msg", " user registered sucessfully");
		}
 		return response;
	}

	public Map<String, Object> allInOneLogIn(String email, String password) {
		Map<String, Object> response = new HashMap<String, Object>();
 		
 
		if (email != null) {
			User user = userRegistrationRepository.findByEmail(email);
			Driver d=driverRepository.findByEmail(email);

			if (user != null && user.getPassword().toString().equals(password)) {
		            user.setPassword(null);
					response.put("msg", "user login succesful");
					response.put("status",1);
                    response.put("detail", user);
				} else if(d !=null  && d.getPassword().toString().equals(password)) {
		            d.setPassword(null);
					response.put("msg", "driver login succesful");
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
}
	
