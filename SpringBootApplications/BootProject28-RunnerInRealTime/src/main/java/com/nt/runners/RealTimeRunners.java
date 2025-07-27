package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@Component
public class RealTimeRunners implements CommandLineRunner {

	
	public RealTimeRunners() {
		System.err.println("RealTimeRunners.RealTimeRunners() : : Constructor");
	}

	@Autowired
	private PayrollOperationController  payroll;
	
	@Override
	public void run(String... args) throws Exception {
		//get controller object

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
