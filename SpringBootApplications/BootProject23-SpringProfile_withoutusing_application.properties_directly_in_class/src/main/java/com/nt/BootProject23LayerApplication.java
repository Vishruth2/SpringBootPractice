package com.nt;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProject23LayerApplication {
	
	@Autowired
	public Environment env;
	
	@Bean("c3p0DS")
	@Profile("uat")
	public DataSource createC3p0() throws Exception {
		ComboPooledDataSource cpd = new ComboPooledDataSource();
		cpd.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cpd.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cpd.setUser(env.getRequiredProperty("spring.datasource.username"));
		cpd.setPassword(env.getRequiredProperty("spring.datasource.password"));

		
		return cpd;
	}

	public static void main(String[] args) {
		//create SpringApplication object
		 SpringApplication app = new SpringApplication(BootProject23LayerApplication.class);
		 app.setAdditionalProfiles("uat");
		
		//get IOC container
		ApplicationContext ctx=app.run(args);
		
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
