package com.employees.test.services;

import java.util.List;

import com.employees.test.dto.EmployeeDto;

public class CalculateSalary {

	public static EmployeeDto calculateAnualSalary(EmployeeDto employee) {
		if (employee != null && employee.getEmployee_salary() != null) {
			employee.setSalary_anual(employee.getEmployee_salary() * 12);
		}
		return employee;
	}

	public static List<EmployeeDto> calculateAnualSalary(List<EmployeeDto> employees) {
		for (EmployeeDto employee : employees) {
			if (employee != null && employee.getEmployee_salary() != null) {
				employee.setSalary_anual(employee.getEmployee_salary() * 12);
			}

		}
		return employees;
	}

}
