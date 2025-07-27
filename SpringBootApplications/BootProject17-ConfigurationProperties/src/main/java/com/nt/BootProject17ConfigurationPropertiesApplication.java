package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Company;

@SpringBootApplication
public class BootProject17ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx =
				SpringApplication.run(BootProject17ConfigurationPropertiesApplication.class, args);
		
		//get Company object using ctx
		Company com=ctx.getBean("company", Company.class);
		
		//print the com
		System.err.println(com);
	}

}
