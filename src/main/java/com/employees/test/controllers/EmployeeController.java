package com.employees.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employees.test.common.StatusCode;
import com.employees.test.exception.EmployeesTestException;
import com.employees.test.response.ApiResponse;
import com.employees.test.services.EmployeeService;
import com.employees.test.validate.RequestIdEmployee;

@RestController
public class EmployeeController {
    

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RequestIdEmployee requestIdEmployee;


    @CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value="/employee/{id}", produces = "application/json")
    public ResponseEntity<String> getEmployeeById(@PathVariable(required = false) String id) {
        
        try {
			requestIdEmployee.validateId(id);
            System.out.println("IDDDDDDDDDDDDFORRRRR");
            System.out.println(id);
            
			ApiResponse response =  this.employeeService.getById(Integer.parseInt(id));
            
			return new ResponseEntity<>(response.toString(), response.getStatusCode());
        } catch (EmployeesTestException cException) {
			ApiResponse response = new ApiResponse();
			response.setMessage(StatusCode.ERROR.toString());
			response.setStatus(cException.getError().getStatus());
            return new ResponseEntity<>(response.toString(), response.getStatusCode());
        }
    }

	
    @CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value="/employees", produces = "application/json")
	 public ResponseEntity<String> getAllEmployees(){
        ApiResponse response = employeeService.getAll();
        return new ResponseEntity<>(response.toString(), response.getStatusCode());
	 }

}
