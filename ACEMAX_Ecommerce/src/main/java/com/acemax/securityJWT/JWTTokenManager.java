package com.acemax.securityJWT;

import java.util.Date;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JWTTokenManager {

	private final String SECRET_KEY = "fergughsbur2363dfgbffxhgfdv";

	private long expiryTimeInMillis = 5 * 60 * 1000;
	
	public String createToken(String Username) {
		
		String token = Jwts.builder()
				.setSubject(Username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+expiryTimeInMillis))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
		
		return token;
	}

	public boolean isValidToken(String loginusername, String token) {
  
		String tokenUsername = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();	
		
		return loginusername.equalsIgnoreCase(tokenUsername);
	}

	public boolean isTokenTimeValid(String token)
	{
		Date expiryTime = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody()
				.getExpiration();
		
		boolean isExpired = expiryTime.after(new Date());
		return isExpired;
	}
	
}
