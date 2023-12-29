package com.ty.springbootdemoproject.exception;




public class IdNotFoundException  extends RuntimeException{

	private String message;;
	
	
	public IdNotFoundException() {
		
	}
	
	public IdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}
	
}
