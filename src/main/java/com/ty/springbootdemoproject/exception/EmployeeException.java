package com.ty.springbootdemoproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springbootdemoproject.dto.ResponseStructure;

@ControllerAdvice
public class EmployeeException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotPresentException(IdNotFoundException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("not found");
		structure.setStatuCode(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NameEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> nameEmailNotPresentException(NameEmailNotFoundException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("not found");
		structure.setStatuCode(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
