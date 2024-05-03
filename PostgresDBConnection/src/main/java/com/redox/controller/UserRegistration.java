package com.redox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redox.dto.RegisterUser;
import com.redox.dto.UserDetails;

@RestController
public class UserRegistration {

	@Autowired
	RegisterUser register;
	
	@PostMapping(path="/user/register" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public String getUserRegistration(@RequestBody UserDetails userdetails) {
		
		
		register.registerUserNow(userdetails);
		return "register success";
	}
}
