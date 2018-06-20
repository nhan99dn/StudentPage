package com.crunchify.jsp.servlet;

public class Student {
	
	private int id;
	private String firstname;
	private String lastname;
	private int year;
	private String school;
	private String username;
	private String password;
	private boolean valid ;
	
	//index getter
	public int getId() {
	
		return this.id;
		
	}
	
	//index setter
	public void setId(int id) {
		
		this.id = id;
		
	}
	//firstname getter
	
	public String getFirstName() {
		
		return this.firstname;
		
	}
	
	//firstname setter
	
	public void setFirstName(String firstname) {
		
		this.firstname = firstname;
		
	}
	
	//lastname getter
	public String getLastName() {
		
		return this.lastname;
		
	}
	
	//lastname setter
	public void setLastName(String lastname) {
		
		this.lastname = lastname;
		
	}
	
	//year getter
	public int getYear() {
		
		return this.year;
		
	}
	
	//year setter
	public void setYear(int year) {
		
		this.year = year;
		
	}
	
	//school getter
	public String getSchool() {
		
		return this.school;
		
	}
	
	//school setter
	public void setSchool(String school) {
		
		this.school = school;
	}
	
	
	//username getter
	public String getUsername() {
		
		return this.username;
		
	}
	
	//username setter
	public void setUsername(String username) {
		
		this.username = username;
	}
	
	//password getter
	public String getPassword() {
		
		return this.password;
		
	}
	
	//password setter
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	//Valid getter 
	public boolean isValid() {
		
		return valid;
	}
	
	//Valid setter
	public void setValid(boolean valid) {
		
		this.valid = valid;
	}
	
}
