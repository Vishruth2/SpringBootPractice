package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProject18ConfigurationPropertiesToCollectionsandArraysApplication {

	public static void main(String[] args) {
		//to get IOC container
		ApplicationContext ctx=
				SpringApplication.run(BootProject18ConfigurationPropertiesToCollectionsandArraysApplication.class, args);
		
		//get employee object
		Employee emp = ctx.getBean("emp", Employee.class);
		
		System.err.println(emp);
	}

}
