package com.newproject.newolaversion.baen;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Data
@ToString
public class UserWithCarBean {


 	private int id;
	private String name;
	private String email;
	private String password;
	private MultipartFile cPhoto1;
	private MultipartFile cPhoto2;
	private MultipartFile cPhoto3;
	private MultipartFile cDocument1;
	private MultipartFile cDocument2;
	private MultipartFile cDocument3;
	private MultipartFile cDocument4;
	private String condition;
	private String contactNumber;
	private String status;

}
