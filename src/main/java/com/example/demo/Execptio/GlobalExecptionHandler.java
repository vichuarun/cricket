package com.example.demo.Execptio;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExecptionHandler {
	
	@ExceptionHandler(ResourceNotfFound.class)
	public ResponseEntity<?> handleResourceNotFoundExeception(ResourceNotfFound eFound,WebRequest request){
		ErrorDeatail deatail=new ErrorDeatail(new Date(), eFound.getMessage(), request.getDescription(false));
		return new ResponseEntity(deatail,HttpStatus.NOT_FOUND);
	}
	
	/*
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleResourceNotFoundExeception(Exception exception,WebRequest request){
		ErrorDeatail deatail=new ErrorDeatail(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(deatail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	*/


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleResourceNotFoundExeception(MethodArgumentNotValidException exception){
		ErrorDeatail errorDeatail=new ErrorDeatail(new Date(), "validation Error",exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity(errorDeatail,HttpStatus.BAD_REQUEST);
	}
	
}
