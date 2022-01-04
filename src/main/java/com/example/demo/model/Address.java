package com.example.demo.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Address {
	
	@Size(min = 2, message = "enter housename")
	public String housename;
	@Size(min = 2, message = "enter street name")	
	public String streetname;
	@Size(min = 2, message = "enter postoffice")	
	public String postoffice;
	@Size(min = 2, message = "enter state")	
	public String state;
	@Pattern(regexp="^[0-9]{6}",message="enter valid pincode")  
	public String pincode;

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
