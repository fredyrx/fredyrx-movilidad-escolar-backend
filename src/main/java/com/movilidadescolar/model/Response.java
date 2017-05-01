package com.movilidadescolar.model;

public class Response{
	
	private int status;
	private Object data;
	private String error;
	private String message;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Response(Object data, String message) {
		this.data = data;
		this.error = "";
		this.status = 200;
		this.message = message;
	}
	
	protected Response(){
		
	}
	
}