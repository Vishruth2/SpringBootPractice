package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class TestRunners implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService dservice;
	
	@Override
	public void run(String... args) throws Exception {
//		Doctor d = new Doctor();
//		d.setDocName("Arjun Reddy Deshmukh");
//		d.setSpecialization("house surgeon");
//		d.setSalary(250000.00);
//		String result=dservice.registerDoctor(d);
//		System.err.println("The details of doctor :: "+result);
		
//		Doctor d1 = new Doctor();
//		d1.setDocName("Vishruth vardhan");
//		d1.setSpecialization("Cardiologist");
//		d1.setSalary(350000.00);
//		Doctor d2 = new Doctor();
//		d2.setDocName("Lenardo Da vinci");
//		d2.setSpecialization("Neurologist");
//		d2.setSalary(150000.00);
//		
//		String msg =dservice.registerGroupOfDoctors(List.of(d1, d2));
//		//or
////		String msg1=dservice.registerGroupOfDoctors(Arrays.asList(d1,d2));
//		
//		System.err.println(msg);
		
		try {
			boolean flag=dservice.isDoctorAvailable(952);
			if (flag) {
				System.err.println("Doctor available");
			}
			else {
				System.err.println("Doctor not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
