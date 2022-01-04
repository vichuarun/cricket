package com.example.demo.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserAdd {
	
	private int id;
	@NotNull
	@Size(min = 2, message = "Firstname atleast 2 charactor")
	
	
	private String fname;
	
	@Size(min = 1, message = "Lastname Required")
	private String lname;
	
	@Size(min = 2, message = "Father name atleast 2 charactor")
	private String namefather;
	@Valid
	private Address address;
	
	@NotBlank(message = "mobileNumber is required")
	@Pattern(regexp="^[0-9]{10}",message="enter valid mobile no")  
     private String phoneno;
	

	@Size(min = 2, message = "enter username")	
	private String username;
	 //  @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3") 
	@Size(min = 2, message = "enter password")	
	private String password;
	@Size(min = 2, message = "enter confirm password")	
	private String conpassword;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getNamefather() {
		return namefather;
	}
	public void setNamefather(String namefather) {
		this.namefather = namefather;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getConpassword() {
		return conpassword;
	}
	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}
	public UserAdd(int id, String fname, String lname, String namefather, Address address, String phoneno,
			String username, String password, String conpassword) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.namefather = namefather;
		this.address = address;
		this.phoneno = phoneno;
		this.username = username;
		this.password = password;
		this.conpassword = conpassword;
	}
	public UserAdd() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
