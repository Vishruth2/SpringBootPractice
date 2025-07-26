package com.nt;

import com.nt.sbeans.Mobile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootProject03OnDependencyInjectionStrategyPattern2Application {

	public static void main(String[] args) {
		//IOC container is created
		try(ConfigurableApplicationContext ctx
				=SpringApplication.run(BootProject03OnDependencyInjectionStrategyPattern2Application.class, args);)
		{
			//Get the Target class object
			Mobile mobile = ctx.getBean("mobile", Mobile.class);
			
			//invoke the b.logic method
			mobile.simDetails();
			
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
