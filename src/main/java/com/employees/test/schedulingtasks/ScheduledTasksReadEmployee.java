package com.employees.test.schedulingtasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.employees.test.services.EmployeeService;
import com.employees.test.services.ReadService;

import com.employees.test.dto.EmployeeDto;

@Component
@EnableScheduling 
public class ScheduledTasksReadEmployee {

    @Autowired
    private ReadService employeeService;

    @Autowired
    private EmployeeService dbEmployeeService;
	
	@Scheduled(fixedRate = 350000)
	public void reportCurrentTime() {
		List<EmployeeDto> data = employeeService.getEmployeesApi();
		System.out.println("Guardar" + data.toString());			

		if (!data.isEmpty()) {
			clearEmployeeTable();
			dbEmployeeService.saveAll(data);
		}
		System.out.println(
		  "Fixed rate task - " + data);
	}

    private void clearEmployeeTable() {
        dbEmployeeService.deleteAll(); // Borra todos los registros de la tabla employees
    }

}
