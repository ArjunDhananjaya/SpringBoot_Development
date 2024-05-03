package com.acemax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acemax.dto.UserDetails;
import com.acemax.dto.UserRegistration;
import com.acemax.entity.UserData;
import com.acemax.repository.userRegisterRepository;
@Service
public class UserRegisterService implements UserRegistration {

	
	@Autowired
	userRegisterRepository userRepo;
	
	@Override
	public String addUser(UserDetails userDetails) {
		
		UserData user = new UserData();
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setContact(userDetails.getContact());
		user.setGender(userDetails.getGender());
		user.setCity(userDetails.getCity());
		user.setPassword(userDetails.getPassword());
		user = userRepo.save(user);
		
		return "User Register Successfull";
	}
}
