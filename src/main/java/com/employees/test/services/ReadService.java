package com.employees.test.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.test.repositories.ReadRepository;
import com.google.gson.Gson;

import com.employees.test.dto.EmployeeDto;
import com.employees.test.response.EmployeeResponse;
import com.employees.test.response.ListEmployeesResponse;

@Service
public class ReadService {
    
    @Autowired
    ReadRepository readRepository;

    public List<EmployeeDto> getEmployeesApi() {
        List<EmployeeDto> employees = new ArrayList<>();
        try {
            
            StringBuilder response = readRepository.getEmployeesApi();

            Gson gson = new Gson();
            ListEmployeesResponse apiResponse = gson.fromJson(response.toString(), ListEmployeesResponse.class);
            if (apiResponse != null && apiResponse.getData() != null) {
                employees = CalculateSalary.calculateAnualSalary(apiResponse.getData());

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }
    public EmployeeDto getEmployeeApi(int idEmployee) {
        EmployeeDto employee = new EmployeeDto();
        try {
            
            StringBuilder response = readRepository.getEmployeeApi(idEmployee);

            Gson gson = new Gson();
            EmployeeResponse apiResponse = gson.fromJson(response.toString(), EmployeeResponse.class);
            if (apiResponse != null && apiResponse.getData() != null) {
                employee = CalculateSalary.calculateAnualSalary(apiResponse.getData());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

}
