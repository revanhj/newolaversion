package com.newproject.newolaversion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.newolaversion.baen.DriverBean;
import com.newproject.newolaversion.model.Driver;
import com.newproject.newolaversion.model.UploadFile;
import com.newproject.newolaversion.repository.DriverRepository;
import com.newproject.newolaversion.repository.UserRegistrationRepository;
import com.newproject.newolaversion.service.DriverService;
import com.newproject.newolaversion.serviceimpl.DriverServiceImpl;

@RestController
@RequestMapping(value = "driver")
public class DriverController {

	@Autowired
	private DriverService driverService;

	@Autowired
	private DriverServiceImpl driverServiceImpl;

	@Autowired
	private UploadFile uploadFile;

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@GetMapping("/hi")
	public String show() {
		return "OHHH................RD.......?";

	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> driverRegister(@RequestBody Driver driver) {
		return driverService.driverRegister(driver);

	}

	@RequestMapping(value = "/{email}/{password}", method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> OneLogInForAll(@PathVariable String email, @PathVariable String password) {
		System.out.println("hggggggggggggggg");
		return driverService.OneLogInForAll(email, password);

	}

	@PostMapping("/add/file")
	public Map<String, Object> saveFile(@RequestBody DriverBean t) {
		System.out.println("1qqqqqqqqqqqqqqqqqq");
		Map<String, Object> map = new HashMap<>();
		Driver email = driverRepository.findByEmail(t.getEmail());
		Driver contactNuber = driverRepository.findByContactNumber(t.getContactNumber());

		if (contactNuber != null) {
			map.put("msg", "duplicate contactNumber");

		} else if (email != null) {
			map.put("msg", "duplicate emailid");

		} else {

			Driver d = new Driver();
			d.setContactNumber(t.getContactNumber());
			d.setCreatedAt(t.getCreatedAt());
			d.setDate(t.getDate());
			d.setDrivingLecence(t.getDrivingLecence());
			d.setDutyTiming(t.getDutyTiming());
			d.setEmail(t.getEmail());
			d.setExperience(t.getExperience());
			d.setExpiredDate(t.getExpiredDate());
			d.setFirstName(t.getFirstName());
			d.setFrom(t.getFrom());
			d.setId(t.getId());
			d.setLastName(t.getLastName());
			d.setPassword(t.getPassword());
			d.setStatus(t.getStatus());
			d.setTo(t.getTo());
			d.setUpdatedAt(t.getUpdatedAt());
			d.setDriverPhoto(uploadFile.upload(t.getDriverPhoto()));
			d.setDriverPhoto1(uploadFile.upload(t.getDriverPhoto1()));
			d = driverRepository.save(d);

			map.put("msg", "successfully saved");
			map.put("status", "1");
			map.put("data", d);
		}
		return map;
	}

	@PostMapping("/update")
	public <T> Map<String, Object> save(DriverBean t) {
		Map<String, Object> map = new HashMap<>();
		// Driver c= driverRepository.save(t);
		// if(c.getId()==t.getId()) {
		// Driver d=new Driver();

		Date ds = new Date();
		Optional<Driver> id = driverRepository.findById(t.getId());
		if (id.isPresent()) {
			Driver d = id.get();
			d.setContactNumber(t.getContactNumber());
			d.setCreatedAt(t.getCreatedAt());
			d.setDate(t.getDate());
			d.setDrivingLecence(t.getDrivingLecence());
			d.setDutyTiming(t.getDutyTiming());
			d.setEmail(t.getEmail());
			d.setExperience(t.getExperience());
			d.setExpiredDate(t.getExpiredDate());
			d.setFirstName(t.getFirstName());
			d.setFrom(t.getFrom());
			d.setId(t.getId());
			d.setLastName(t.getLastName());
			d.setPassword(t.getPassword());
			d.setTo(t.getTo());
			d.setUpdatedAt(t.getUpdatedAt());
			d.setDriverPhoto(uploadFile.upload(t.getDriverPhoto()));
			d.setDriverPhoto1(uploadFile.upload(t.getDriverPhoto1()));
			d.setStatus("book");
			d.setUpdatedAt(ds);
			d.setCreatedAt(ds);
			d = driverRepository.save(d);
			map.put("msg", "successfully updated");
			map.put("data", d);
		} else {
			map.put("msg", "invalid id");
			return map;
		}
		return map;
	}

	@RequestMapping(value = "/{status}", method = RequestMethod.GET, produces = "application/json")
	public List<Driver> getByStatus(@PathVariable String status) {
		return driverServiceImpl.checkStatus(status);

	}
	
	@GetMapping("/join")
	public Object[] joinTwoTable() {
		return driverRepository.findByTwoTable();
		
	}
}
