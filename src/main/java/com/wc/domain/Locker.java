package com.wc.domain;

import java.util.Date;

import javax.persistence.Id;

public class Locker {
	public static final String FREE="FREE";
	public static final String BOOKED="BOOKED";
	@Id
	private Integer id;
	private String status; // FREE/ BOOKED
	private User  userDetails;   // in case of BOOKED else it will be null or empty
	private String password;
	
	private Date bookedDate;   // in case of Booked after checkout we should update with null
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}
	
	
	
}
