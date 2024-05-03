package com.redox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redox.dto.RegisterUser;
import com.redox.dto.UserDetails;
import com.redox.repository.UserRepository;

@Service
public class UserRegistrationService implements RegisterUser {

	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public String registerUserNow(UserDetails userDetails) {
		
		com.redox.entity.UserDetails user = new com.redox.entity.UserDetails();
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		
		user = userRepo.save(user);
		return "User Register Success";
	}

}
