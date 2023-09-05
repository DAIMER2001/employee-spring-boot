package com.employees.test.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employees.test.dto.EmployeeDto;
import com.employees.test.response.ApiResponse;

@Service
public interface EmployeeService {
    public Boolean saveAll(List<EmployeeDto> employees);
	public ApiResponse getAll();
	public ApiResponse getById(int idEmployee);
    public Boolean deleteAll();
}
