package com.newproject.newolaversion.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
 	private String drivingLecence;
	private String expiredDate;
 	private String email;
	private String password;
	private String contactNumber;
	private String experience;
	private String driverPhoto;
	private String driverPhoto1;

	private String dutyTiming;
	private String from;
	private String to;
	private String status;
	private Date date;
	private Date createdAt;
	private Date updatedAt;
 }
