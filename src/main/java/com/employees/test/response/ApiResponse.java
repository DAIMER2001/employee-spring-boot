package com.employees.test.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.google.gson.Gson;


public class ApiResponse implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private String message;
	private transient HttpStatus status;
	
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatusCode() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
