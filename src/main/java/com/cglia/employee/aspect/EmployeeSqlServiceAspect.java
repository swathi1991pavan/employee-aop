package com.cglia.employee.aspect;


import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.springframework.stereotype.Component; 


@Aspect  
@Component  
public class EmployeeSqlServiceAspect { 
	System.out.println("hi");
	@Before(value = "execution(* com.cglia.employee.service.EmployeeSqlService.*(..))")  
	public void beforeAdvice(JoinPoint joinPoint) {  
		System.out.println("Before method:");  
		System.out.println("added the method");
		//System.out.println("Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);  
}  
} 
/*@Aspect  
@Component  
public class EmployeeSqlServiceAspect   
{  
@Before(value = "execution(* com.cglia.aopexample.service.EmployeeService.*(..)) and args(empId, fname, sname)")  
public void beforeAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {  
System.out.println("Before method:" + joinPoint.getSignature());  
System.out.println("Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);  
}  
}*/  