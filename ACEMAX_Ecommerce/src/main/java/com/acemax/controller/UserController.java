package com.acemax.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.acemax.dto.AmazonUser;
import com.acemax.dto.UserDetails;
import com.acemax.dto.UserRegistration;

@RestController
public class UserController {

	@Autowired
	UserRegistration userRegistration;
	
	@PostMapping(path="/user/register", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@RequestBody UserDetails userDetails)
	{
		System.out.println(userDetails.getUsername());
		
	 userRegistration.addUser(userDetails);
		return "user registered successfull";
	}
	

	@PostMapping("/test")
	public String getAmazonUser(@RequestBody AmazonUser amazon)
	{
		HttpEntity<AmazonUser> httpEntity = new HttpEntity<AmazonUser>(amazon);
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<String> responseEntity =restTemp.exchange("http://localhost:9009/amazon/user/create",HttpMethod.POST ,httpEntity,String.class);
		
		
		String response = responseEntity.getBody();
		return response;
	}
}
