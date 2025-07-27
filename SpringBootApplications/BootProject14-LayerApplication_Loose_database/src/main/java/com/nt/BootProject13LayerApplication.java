package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProject13LayerApplication {

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
