package com.employees.test.repositories;


import com.employees.test.models.EmployeeModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    @Modifying
    @Query("DELETE FROM EmployeeModel e WHERE e.id_employee_api IS NOT NULL")
    void deleteEmployeesWithNotNullIdApi();
}
