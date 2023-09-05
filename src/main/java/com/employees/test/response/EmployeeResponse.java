package com.employees.test.response;

import com.employees.test.dto.EmployeeDto;

public class EmployeeResponse extends ApiResponse {

	private EmployeeDto data;

	public EmployeeResponse() {
		super();
	}

	public EmployeeDto getData() {
		return data;
	}

	public void setData(EmployeeDto data) {
		this.data = data;
	}
	
}
