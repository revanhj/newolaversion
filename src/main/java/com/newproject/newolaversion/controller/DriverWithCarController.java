package com.newproject.newolaversion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.newolaversion.baen.DriverBean;
import com.newproject.newolaversion.baen.UserWithCarBean;
import com.newproject.newolaversion.model.UploadFile;
import com.newproject.newolaversion.model.Driver;
import com.newproject.newolaversion.model.DriverWithCar;
import com.newproject.newolaversion.repository.DriverWithCarRepository;
import com.newproject.newolaversion.serviceimpl.DriverWithCarServiceImpl;

@RestController
@RequestMapping(value = "userwithcar")
public class DriverWithCarController {

	
	@Autowired
	public DriverWithCarRepository driverWithCarRepository;
	
	@Autowired 
	public UploadFile uploadFile;

	@Autowired
	private DriverWithCarServiceImpl driverWithCarServiceImpl;
	
	@PostMapping("/ad/file")
	public <T> T saveFile(UserWithCarBean t) {
		Map<String,Object> map= new HashMap<>();
		DriverWithCar email=driverWithCarRepository.findByEmail(t.getEmail());
		DriverWithCar contactNuber=driverWithCarRepository.findByContactNumber(t.getContactNumber());

		if(contactNuber!= null){
			map.put("msg", "duplicate contactNumber");
 
		}
		else if(email!=null){
			map.put("msg", "duplicate emailid");
 
		}else {
		DriverWithCar d=new DriverWithCar();
 		d.setName(t.getName());
 		d.setEmail(t.getEmail());
  		d.setId(t.getId());
 		d.setPassword(t.getPassword());
 		d.setCDocument1(uploadFile.upload(t.getCDocument1()));
  		d.setCDocument2(uploadFile.upload(t.getCDocument2()));
  		d.setCDocument3(uploadFile.upload(t.getCDocument3()));
  		d.setCDocument4(uploadFile.upload(t.getCDocument4()));
  		d.setCPhoto1(uploadFile.upload(t.getCPhoto1()));
  		d.setCPhoto2(uploadFile.upload(t.getCPhoto2()));
  		d.setCPhoto3(uploadFile.upload(t.getCPhoto3()));
        d.setCondition(t.getCondition());
        d.setContactNumber(t.getContactNumber());
        d.setStatus(t.getStatus());
		d= driverWithCarRepository.save(d);
		 
			map.put("msg", "successfully saved");
			map.put("status","1");
			map.put("data",d);
		}
		return (T) map;
	}
	
 	@PostMapping("/update")
	public <T> Map<String, Object> save(UserWithCarBean t) {
		Map<String,Object> map= new HashMap<>();
	//	Driver c= driverRepository.save(t);
		//if(c.getId()==t.getId()) {
		//Driver d=new Driver();

		Date ds=new Date();
 		Optional<DriverWithCar> id=driverWithCarRepository.findById(t.getId());
            if(id.isPresent()) {
            DriverWithCar d=id.get();
	        d.setContactNumber(t.getContactNumber());
 	        d.setEmail(t.getEmail());
 	        d.setPassword(t.getPassword());
  	        d.setId(t.getId());
 			d.setStatus("book");
 			d.setCDocument1(uploadFile.upload(t.getCDocument1()));
 			d.setCDocument2(uploadFile.upload(t.getCDocument2()));
 			d.setCDocument3(uploadFile.upload(t.getCDocument4()));
 			d.setCDocument4(uploadFile.upload(t.getCDocument4()));
 			d.setCondition(t.getCondition());
 			d.setCPhoto1(uploadFile.upload(t.getCPhoto1()));
 			d.setCPhoto2(uploadFile.upload(t.getCPhoto2()));
 			d.setCPhoto3(uploadFile.upload(t.getCPhoto3()));
             d= driverWithCarRepository.save(d);
            map.put("msg", "successfully updated");
 			map.put("data",d);
      	}else {
     		map.put("msg", "invalid id");
     		return map;
     	}
			return map;
 	}
 	
	@RequestMapping(value = "{status}",method = RequestMethod.GET,produces = "application/json")
	public List<DriverWithCar> getStatus(@PathVariable String status){
		return driverWithCarServiceImpl.getStatus(status);
		
	}
}
 
