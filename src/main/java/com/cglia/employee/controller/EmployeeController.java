package com.cglia.employee.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.employee.model.Employee;
import com.cglia.employee.service.EmployeeSqlService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
    public EmployeeSqlService employeeService ;
	
	
	
	@GetMapping("/employees")
	public ArrayList<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId){
      return employeeService.getEmployeeById(employeeId);
    } 
	
	@PostMapping("/employees/addEmployee")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		System.out.println("in employeecontroller method");
		System.out.println(employee.getEmployeeName());
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/employees/updateEmployee/{employeeId}")
	public Employee updateEmployee(@PathVariable("employeeId") int employeeId , @RequestBody Employee employee) {
		return employeeService.updateEmployee(employeeId, employee);
	}
	
	@DeleteMapping("/employees/deleteEmployee/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
}
