//BootProject01FirstAppDependencyInjectionApplication.java
package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
public class BootProject01FirstAppDependencyInjectionApplication {
	
	@Bean(name = "ldt")
	public LocalDateTime createLDT() {
		System.out.println("BootProject01FirstAppDependencyInjectionApplication.createLDT()");
		return LocalDateTime.now();
		
	}

	public static void main(String[] args) {
		//get Access of IOC container
		ApplicationContext ctx =SpringApplication.run(BootProject01FirstAppDependencyInjectionApplication.class, args);
		//Get the target class spring bean object
		WishMessageGenerator gen=ctx.getBean("wmg", WishMessageGenerator.class);
		//invoke the business method 
		String result = gen.generateMessage("Vishruth");
		//print the result
		System.out.println("Wish Message Genertor Result :"+result);
		//close the container
		((ConfigurableApplicationContext) ctx).close();
	}

}
