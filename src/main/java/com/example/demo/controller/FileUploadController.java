package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Respositary.FilieUploadRespositary;

@RestController
public class FileUploadController {

	@Autowired
	FilieUploadRespositary fileUploadService;

	@PostMapping("/profilepic")
	public String uploadfile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {

		fileUploadService.uploadFile(file);
		return "File Uploaded";
	}

}
