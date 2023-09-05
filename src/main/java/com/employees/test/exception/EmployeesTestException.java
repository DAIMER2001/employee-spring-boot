package com.employees.test.exception;

import org.springframework.http.HttpStatus;

import com.employees.test.common.ErrorCode;
import com.employees.test.common.GetMessageError;
import com.employees.test.response.ErrorResponse;

public class EmployeesTestException  extends Exception  {
	
	private static final long serialVersionUID = 123123132123123L;
	private final ErrorResponse error;
	
	public EmployeesTestException(ErrorCode errorCode, GetMessageError message, HttpStatus httpStatus, String ... customMessage) {
		super(errorCode.getMessage() + ' ' + errorCode.getCode() );
		error = new ErrorResponse();
		error.setTitle("Error As occurred");
		error.setMessage(errorCode.getMessage());
		error.setStatus(httpStatus);
	}
	
	public ErrorResponse getError() {
		return error;
	}
}