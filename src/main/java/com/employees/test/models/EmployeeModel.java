package com.employees.test.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_employee_api", nullable = true)
    private Long id_employee_api;

    @Column(name="employee_name", nullable = true)
    private String employee_name;

    @Column(name="employee_salary", nullable = true)
    private Long employee_salary;

    @Column(name="employee_age", nullable = true)
    private Integer employee_age;

    @Column(name="profile_image", nullable = true)
    private String profile_image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_employee_api() {
        return id_employee_api;
    }

    public void setId_employee_api(Long id_employee_api) {
        this.id_employee_api = id_employee_api;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Long getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Long employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }


}
