package com.cglia.employee.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cglia.employee.model.Employee;
import com.cglia.employee.model.EmployeeRowMapper;
import com.cglia.employee.repository.EmployeeRepository;

@Service
public class EmployeeSqlService implements EmployeeRepository {
   
	@Autowired
    private JdbcTemplate db;
	
	@Override
	public ArrayList<Employee> getEmployees() {
		
		List<Employee> employeeData = db.query("select * from employee", new EmployeeRowMapper());
	    ArrayList<Employee> employees = new ArrayList<>(employeeData);
	 	return employees;
	    
	}
	
	public Employee addEmployee(Employee employee) {
		
		db.update("insert into employee(EmployeeName,Email,Department) values(?,?,?)",
				employee.getEmployeeName(),employee.getEmail(),employee.getDepartment());
		
		//System.out.println("service method");
		//System.out.println(employee.getEmployeeName());
		//System.out.println(employee.getEmployeeName());
		//System.out.println(employee.getEmployeeName());
		Employee savedEmployee = db.queryForObject("select * from employee where email=?" , new EmployeeRowMapper() ,employee.getEmail());
		
		return savedEmployee;
				
	}

	public Employee getEmployeeById(int employeeId) {
		try {
			Employee employee = db.queryForObject("select * from employee where EmployeeID=?" , new EmployeeRowMapper() , employeeId);
			return employee;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		try {
			
			Employee existingEmployee = db.queryForObject("select * from employee where EmployeeID=?" , new EmployeeRowMapper() , employeeId);
			if(existingEmployee != null) {
				
				if(employee.getEmployeeName() != null){
		            db.update("update employee set EmployeeName = ? where EmployeeID = ?", employee.getEmployeeName(), employeeId);
		        }
				
		        if(employee.getEmail() != null){
		            db.update("update employee set Email = ? where  EmployeeID= ?", employee.getEmail(), employeeId);
		        }
		        
				if(employee.getDepartment() !=null) {
					db.update("update employee set Department = ? where EmployeeID=?", employee.getDepartment(), employeeId);
				}
				
				
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		}
		return getEmployeeById(employeeId);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		try {
			
			db.update("delete from employee where EmployeeId = ?", employeeId);
			
		}catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	

}
