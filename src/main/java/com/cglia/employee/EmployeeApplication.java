package com.cglia.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass=true) 
public class EmployeeApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
