package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProject12LayerApplication {
	
	@Autowired
	private Environment env;
	
	@Bean("c3p0Ds")
	public ComboPooledDataSource createC3P0() throws Exception {
		System.out.println("BootProject12LayerApplication.createC3P0() helps to create c3p0 datasource object");
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.username"));
		cpds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		cpds.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0minsize")));
		cpds.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0maxsize")));
		
		return cpds;
	}

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=
				SpringApplication.run(BootProject12LayerApplication.class, args);
		
		//get controller object
		PayrollOperationController payroll=ctx.getBean(PayrollOperationController.class, "payrollController");
		//invoke the business method
		try {
			List<Employee> list=payroll.showEmployeeByDesgs("CLERK", "MANAGER", "ANALYST");
			
			//loop them 
			list.forEach(emp ->{
				System.err.println(emp);
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal errors -----====---> "+e.getMessage());
		}
	}

}
