package com.employees.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employees.test.dto.EmployeeDto;
import com.employees.test.exception.EmployeesTestException;
import com.employees.test.models.EmployeeModel;
import com.employees.test.repositories.IEmployeeRepository;
import com.employees.test.response.ApiResponse;
import com.employees.test.response.EmployeeResponse;
import com.employees.test.response.ListEmployeesResponse;
import com.employees.test.services.EmployeeService;
import com.employees.test.services.ReadService;


import com.employees.test.common.ErrorCode;
import com.employees.test.common.GetMessageError;
import com.employees.test.common.StatusCode;
@Service
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    ReadService readService;

	@Autowired
	GetMessageError messages;

	@Override
    public ApiResponse getAll() {
        ListEmployeesResponse response = new ListEmployeesResponse();
		try {
            List<EmployeeDto> data = readService.getEmployeesApi();
            if (!data.isEmpty()) {
                response.setData(data);
                response.setMessage(StatusCode.SUCCESS.toString());
                response.setStatus(HttpStatus.OK);
            } else {
                ApiResponse generalResponse = new ApiResponse();
                generalResponse.setMessage(StatusCode.ERROR.toString());
                generalResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS);
                return generalResponse;
            }
            return response;
        } catch (Exception e) {
			EmployeesTestException cException = new EmployeesTestException(ErrorCode.BAD_REQUEST, messages,HttpStatus.INTERNAL_SERVER_ERROR);
			ApiResponse generalResponse = new ApiResponse();
			generalResponse.setMessage(StatusCode.ERROR.toString());
			generalResponse.setStatus(cException.getError().getStatus());
			return generalResponse;
		}
    }

	@Override
    public ApiResponse getById(int idEmployee) {
        System.out.println("IDDDD");        
        System.out.println("IDDDD");
        System.out.println("IDDDD");
        System.out.println("IDDDD");
        System.out.println("IDDDD");
        System.out.println("IDDDD");
        System.out.println("IDDDD");
        System.out.println("IDDDD");
        System.out.println("IDDDD");
        System.out.println("IDDDD");

        EmployeeResponse response = new EmployeeResponse();
		try {
            EmployeeDto data = readService.getEmployeeApi(idEmployee);
            if (data.getId() != null) {
                response.setData(data);
                response.setMessage(StatusCode.SUCCESS.toString());
                response.setStatus(HttpStatus.OK);
            } else {
                ApiResponse generalResponse = new ApiResponse();
                generalResponse.setMessage(StatusCode.ERROR.toString());
                generalResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS);
                return generalResponse;
            }
            return response;
        } catch (Exception e) {
			EmployeesTestException cException = new EmployeesTestException(ErrorCode.BAD_REQUEST, messages,HttpStatus.INTERNAL_SERVER_ERROR);
			ApiResponse generalResponse = new ApiResponse();
			generalResponse.setMessage(StatusCode.ERROR.toString());
			generalResponse.setStatus(cException.getError().getStatus());
			return generalResponse;
		}
    }

    @Override
    public Boolean saveAll(List<EmployeeDto> employees) {
         try {
            for (EmployeeDto employee : employees) {
                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setId_employee_api(employee.getId());
                employeeModel.setEmployee_name(employee.getEmployee_name());
                employeeModel.setEmployee_salary(employee.getEmployee_salary());
                employeeModel.setEmployee_age(employee.getEmployee_age());
                employeeModel.setProfile_image(employee.getProfile_image());
                
                employeeRepository.save(employeeModel);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    public Boolean deleteAll() {
        try {
            employeeRepository.deleteEmployeesWithNotNullIdApi();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
