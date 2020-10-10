package com.newproject.newolaversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newproject.newolaversion.model.User;
 
public interface UserRegistrationRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

	User findByPhoneNo(String phoneNo);

}
