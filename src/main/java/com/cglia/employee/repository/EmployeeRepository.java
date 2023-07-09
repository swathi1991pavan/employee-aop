package com.cglia.employee.repository;

import java.util.ArrayList;

import com.cglia.employee.model.Employee;

public interface EmployeeRepository {
	
	ArrayList<Employee> getEmployees();
	
	Employee addEmployee(Employee employee);
	
	Employee getEmployeeById(int employeeId);
		
	Employee updateEmployee(int employeeId,Employee employee);
	
	void deleteEmployee(int employeeId);

}
