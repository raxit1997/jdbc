package com.zilker.beans;

public class Student {
	
	private String regID, firstName, lastName, email;
	
	public Student(String regID, String firstName, String lastName, String email) {
		this.regID = regID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getRegID() {
		return regID;
	}

	public void setRegID(String regID) {
		this.regID = regID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
