package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProject28LayerApplication {

	public static void main(String[] args) {
		System.err.println("Main method");
				SpringApplication.run(BootProject28LayerApplication.class, args);
		
		
	}

}
