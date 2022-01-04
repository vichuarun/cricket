package com.example.demo.Respositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Execptio.ResourceNotfFound;
import com.example.demo.model.UserAdd;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserRespositary {
	
	private static final String GET_USER_BY_ID="SELECT * FROM useraddress WHERE ID=?";
	private static final String INSERT_USER_QUERY="insert into useraddress(fname,lname,namefather,address,phoneno,username,password) values(?,?,?,?,?,?,?)";
	private static final String GET_ALLUSER="SELECT * FROM useraddress ";
	
	
	
	
	@Autowired
	private JdbcTemplate jdbctemplate;
ObjectMapper objectMapper=new ObjectMapper();



	public int saveUser(UserAdd userAdd) {
	

	
		String ss;
		try {
			ss = objectMapper.writeValueAsString( userAdd.getAddress());
			
			  jdbctemplate.update(INSERT_USER_QUERY, new Object[] {
						 userAdd.getFname(),userAdd.getLname(),userAdd.getNamefather(),ss,
						  userAdd.getPhoneno(),userAdd.getUsername(),userAdd.getPassword()});
							
		  
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return 1;
	
	}
	
	/*
	 * 
	 * public List<UserAdd> allUser() {
	 * 
	 * 
	 * return
	 * jdbctemplate.query(GET_ALLUSER,BeanPropertyRowMapper.newInstance(UserAdd.
	 * class));
	 * 
	 * }
	 * 
	 * 
	 * public UserAdd getById(Long id) {
	 * 
	 * try { UserAdd useradd=jdbctemplate.queryForObject(GET_USER_BY_ID,
	 * BeanPropertyRowMapper.newInstance(UserAdd.class),id); //String asd=
	 * //objectMapper.readValue(useradd.setAddress(useradd.getAddress()),UserAdd);
	 * return useradd;
	 * 
	 * }catch (Exception e) { throw new ResourceNotfFound("not found   :"+id);
	 * 
	 * //TODO: handle exception } }
	 */
	 
	
}
