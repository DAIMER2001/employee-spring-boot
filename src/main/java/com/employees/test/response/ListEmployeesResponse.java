package com.employees.test.response;

import java.util.List;

import com.employees.test.dto.EmployeeDto;

public class ListEmployeesResponse extends ApiResponse {
    
	private List<EmployeeDto> data;

	public ListEmployeesResponse() {
		super();
	}
	
	public List<EmployeeDto> getData() {
		return data;
	}

	public void setData(List<EmployeeDto> data) {
		this.data = data;
	}
}
