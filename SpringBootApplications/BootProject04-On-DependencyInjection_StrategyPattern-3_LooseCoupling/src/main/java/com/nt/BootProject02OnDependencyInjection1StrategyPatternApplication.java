package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@ImportResource("com/nt/cfgs/applicationContext.xml")
@SpringBootApplication
public class BootProject02OnDependencyInjection1StrategyPatternApplication {

	public static void main(String[] args) {
		//get the ioc container
		try(ConfigurableApplicationContext ctx=
				SpringApplication.run(BootProject02OnDependencyInjection1StrategyPatternApplication.class, args);){
			
			//get the target class object from the IOC container
			Vehicle veh = ctx.getBean(Vehicle.class, "vehicle");
			
			//invoke the business method
			veh.journey("Hyderabad", "Delhi");
			
			
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
