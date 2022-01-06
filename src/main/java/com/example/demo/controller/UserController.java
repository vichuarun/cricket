package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Execptio.ResourceNotfFound;
import com.example.demo.Respositary.UserRespositary;
import com.example.demo.model.UserAdd;


@RestController
public class UserController {


	@Autowired
	private UserRespositary userRespositary;
	
	
	
	@PostMapping("/savedata")
	public void addUser(@Valid @RequestBody UserAdd userAdd) {
		String password=userAdd.getPassword();
		String conpassword=userAdd.getConpassword();
		
		
		try
		{
		
		if(password.equals(conpassword))
				{
				
		 userRespositary.saveUser(userAdd);
			
		}else {
			throw new ResourceNotfFound("password not match");
		}
			
		
		
	}catch (Exception e) {
		throw new ResourceNotfFound("password does not match");
		// TODO: handle exception
	}
	
}
	

/*
 * @GetMapping("/useradd/list") public List<UserAdd> getUsers() { return
 * userRespositary.allUser(); }
 * 
 * 
 * 
 * 
 * @GetMapping("/user/list/{id}") public ResponseEntity<?>
 * getBatsmanById(@PathVariable Long id) {
 * 
 * UserAdd userAdd=userRespositary.getById(id);
 * 
 * 
 * 
 * if(userAdd!=null) { return new ResponseEntity<>(userAdd,HttpStatus.OK);
 * 
 * } else {
 * 
 * return new ResponseEntity<>(new
 * ResourceNotfFound("user not Exist id  :"+id),HttpStatus.NOT_FOUND);
 * 
 * 
 * }
 * 
 * }
 * 
 * 
 */
 
	
}
