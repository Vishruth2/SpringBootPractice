package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Customer;

@SpringBootApplication
public class BootProject19WorkingWithYmlApplication {

	public static void main(String[] args) {	
		//To get an IOC container
		ApplicationContext ctx =
					SpringApplication.run(BootProject19WorkingWithYmlApplication.class, args);
		
		//Retrieve the object
		Customer cust=ctx.getBean("cust", Customer.class);
		//Print the state of customer
		
		System.err.println(cust);
	}

}
