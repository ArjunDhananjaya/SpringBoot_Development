package com.acemax.securityJWT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class JWTTokenController {

	@Autowired
	JWTTokenManager jwtTokenManager;
	//creating token 
	
	@GetMapping("/user/token/{username}")
	public String createToken(@PathVariable String username)
	{
		return jwtTokenManager.createToken("username");
	}
	
	//validating token 
	
	@GetMapping("/validate/token/{username}")
	public boolean isValidToken(@PathVariable String username,@RequestHeader String token) {
		
		return jwtTokenManager.isValidToken(username,token);
	}
}
