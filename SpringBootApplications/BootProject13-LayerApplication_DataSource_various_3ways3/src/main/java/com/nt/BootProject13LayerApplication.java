package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class})
public class BootProject13LayerApplication {
	
	
	
	@Bean("c3p0Ds")
	public ComboPooledDataSource createC3P0() throws Exception {
		System.out.println("BootProject11LayerApplication.createC3P0() helps to create c3p0 datasource object");
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1522:orcl");
		cpds.setUser("system");
		cpds.setPassword("root");
		cpds.setInitialPoolSize(10);
		cpds.setMaxPoolSize(100);
		
		return cpds;
	}

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=
				SpringApplication.run(BootProject13LayerApplication.class, args);
		
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
