package com.ty.springbootdemoproject.dto;

public class ResponseStructure<T> {

	private int statuCode;
	private String message;
	private T data;
	public int getStatuCode() {
		return statuCode;
	}
	public void setStatuCode(int statuCode) {
		this.statuCode = statuCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ResponseStructure() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
