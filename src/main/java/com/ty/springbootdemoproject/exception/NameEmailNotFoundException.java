package com.ty.springbootdemoproject.exception;




public class NameEmailNotFoundException  extends RuntimeException{

	private String message;;
	
	
	public NameEmailNotFoundException() {
		
	}
	
	public NameEmailNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}
	
}
