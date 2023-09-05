package com.employees.test.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
    private transient HttpStatus status;
	private String message;    
	private String title;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
