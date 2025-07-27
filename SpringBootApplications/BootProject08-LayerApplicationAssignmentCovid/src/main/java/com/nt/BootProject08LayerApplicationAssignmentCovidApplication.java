package com.nt;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nit.controller.CovidPatientController;
import com.nit.model.CovidPatient;

@SpringBootApplication
@ComponentScan(basePackages = "com.nit")
public class BootProject08LayerApplicationAssignmentCovidApplication {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		//get ioc container
		ApplicationContext ctx =
				SpringApplication.run(BootProject08LayerApplicationAssignmentCovidApplication.class, args);
		
		//get controller object
		CovidPatientController cpc=ctx.getBean(CovidPatientController.class,"covidController");
		try {
		
			List<CovidPatient> list = cpc.getCovidPatientDetails();
			
			System.out.println("=====================The Covid Patient Details :: ======================");
			list.forEach(cp-> {System.out.println(cp);});
			for(CovidPatient cp : list) {
			//CovidPatient(name=AMIT SHARMA, age=34, gender=MALE, state=DELHI, testDate=2025-01-05, resultDate=2025-05-02, testResult=POSITIVE, hospitalized=YES, recovery=2025-05-10 00:00:00)
				System.err.println("==================================================");
				System.err.println("Name of the Patient :"+cp.getName());
				System.err.println("Age of the Patient :"+cp.getAge());
				System.err.println("Gender of the Patient :"+cp.getGender());
				System.err.println("State of the Patient :"+cp.getState());
				System.err.println("Test Date of the Patient :"+cp.getTestDate().format(formatter));
				System.err.println("Test Result Date of the Patient :"+cp.getResultDate().format(formatter));
				System.err.println("Result of the Patient :"+cp.getTestResult());
			    System.err.println("Result      : " + cp.getTestResult());
			    System.err.println("Hospitalized: " + cp.getHospitalized());

				System.err.println("==================================================");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal errors -----====---> "+e.getMessage());
		}
	}

}
