package com.example.demo.Respositary;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FilieUploadRespositary {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		try
		{
			
			
			file.transferTo(new File("D:\\sts\\demo\\file\\"+file.getOriginalFilename()));
		
		
		 jdbcTemplate.update(
				"insert into file(name,type,size)"
						+ "values(?,?,?)",
						file.getOriginalFilename(),file.getContentType(),file.getSize());
		 
			return file.getOriginalFilename()+" File Upload SuccessFully";
		}
		catch (Exception e) {
			// TODO: handle exception
			return "File Not Saved";
		}
	
	
	}
	
}
