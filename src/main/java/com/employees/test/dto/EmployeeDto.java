package com.employees.test.dto;


public class EmployeeDto {
    
    private Long id;
	
    private String employee_name;

    private Long employee_salary;

    private Integer employee_age;

    private String profile_image;

    private Long salary_anual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getSalary_anual() {
        return salary_anual;
    }

    public void setSalary_anual(Long salary_anual) {
        this.salary_anual = salary_anual;
    }

}
