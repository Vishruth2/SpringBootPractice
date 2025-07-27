package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.PatientInfo;

@SpringBootApplication
public class BootProject16ValueAnnotationSpel2Application {

	public static void main(String[] args) {
		ApplicationContext ctx
		          =SpringApplication.run(BootProject16ValueAnnotationSpel2Application.class, args);
		
		PatientInfo painfo=ctx.getBean("paInfo", PatientInfo.class);
		System.err.println(painfo);
	}

}
