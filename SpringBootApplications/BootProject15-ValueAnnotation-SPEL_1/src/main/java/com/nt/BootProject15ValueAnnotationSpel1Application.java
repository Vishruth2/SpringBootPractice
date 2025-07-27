package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Hotel;

@SpringBootApplication
public class BootProject15ValueAnnotationSpel1Application {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx =
				SpringApplication.run(BootProject15ValueAnnotationSpel1Application.class, args);
		
		//get Hotel object reference
		Hotel hotel = ctx.getBean("hotel", Hotel.class);
		
		System.err.println(hotel);
		
		//close the container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
