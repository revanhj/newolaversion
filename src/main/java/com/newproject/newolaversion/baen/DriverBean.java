	package com.newproject.newolaversion.baen;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

 
@Setter
@Getter
@Data
public class DriverBean {	

	 
 	private int id;
	private String firstName;
	private String lastName;
 	private String drivingLecence;
	private String expiredDate;
 	private String email;
	private String password;
	private String contactNumber;
	private String experience;
	private MultipartFile driverPhoto;
	private MultipartFile driverPhoto1;

	private String dutyTiming;
	private String from;
	private String to;
	private String status;
	private Date date;
	private Date createdAt;
	private Date updatedAt;

}
