package com.acemax.dto;

public class UserDetails {
	private String username;
	private String email;
	private long contact;
	private String password;
	private String gender;
	private String city;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
		System.out.println(gender);
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
		
		System.out.println(city);
	}
	
	
}
