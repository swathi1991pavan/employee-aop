package com.cglia.employee.model;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Employee {
	
	private int employeeId;
	
	@NotEmpty
	@Size(min = 3,max=50)
	private String employeeName;
	
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 3,max=20)
	private String department;
	
	
	
	public Employee(int employeeId, String employeeName, String email, String department) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

}
