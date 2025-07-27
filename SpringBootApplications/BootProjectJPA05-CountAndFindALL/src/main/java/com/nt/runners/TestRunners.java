package com.nt.runners;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
		
//		try {
//			boolean flag=dservice.isDoctorAvailable(952);
//			if (flag) {
//				System.err.println("Doctor available");
//			}
//			else {
//				System.err.println("Doctor not available");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			long result=dservice.getDoctorsCount();
			System.err.println("The total number of counts  :: "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Iterable<Doctor> it = dservice.getAllDoctors();
			//java 8 for each method
			it.forEach(doc->System.err.println(doc));
			System.err.println("==================");
			
			Iterator<Doctor> itr = it.iterator();
			while (itr.hasNext()) {
				Doctor doctor = (Doctor) itr.next();
				System.err.println(doctor);
			}
			
			System.err.println("============");
			System.err.println("Using stream api i.e streamsupport");
			
			StreamSupport.stream(it.spliterator(), false)
								  .forEach(System.err::println);
			
			System.err.println("============");
			System.err.println("Using stream api i.e streamsupport");
			
			List<String> names =
				    StreamSupport.stream(it.spliterator(), false)
				                 .map(doc->doc.getDocName())
				                 .distinct()
				                 .collect(Collectors.toList());
				System.err.println(names);
				
				System.err.println("============");
				System.err.println("Using stream api i.e streamsupport map");
				
				Map<Integer,String> doctorNameMap =
					    StreamSupport.stream(it.spliterator(), false)
					                 .collect(Collectors.toMap(
					                		 doc->doc.getDocId(),  //key doc->doc.getId  Doctor::getDocId
					                         doc->doc.getDocName(),  //value doc-> doc.getDocName Doctor::getDocName
					                         (n1, n2) -> n1)  //mergeFunction → handle duplicates if n1 and n2 have duplicates like id then take the n1 remove n2
					                		 );
					System.err.println(doctorNameMap);
					
					/*
					 * Map<Integer,String> doctorNameMap =
					    StreamSupport.stream(it.spliterator(), false)
					                 .collect(Collectors.toMap(
					                		Doctor::getDocId,  //key doc->doc.getId  Doctor::getDocId
					                       Doctor::getDocName,  //value doc-> doc.getDocName Doctor::getDocName
					                         (n1, n2) -> n1)  //mergeFunction → handle duplicates if n1 and n2 have duplicates like id then take the n1 remove n2
					                		 );
					System.err.println(doctorNameMap);*/
					
				
					System.err.println("============");
					System.err.println("Using stream api i.e streamsupport map");
					StreamSupport.stream(it.spliterator(), false)
				    .filter(doc -> "Cardiologist".equalsIgnoreCase(doc.getSpecialization()))
				    .forEach(System.err::println);
					
					System.err.println("============");
					System.err.println("Using stream api i.e streamsupport map");
					List<Doctor> list =
						    StreamSupport.stream(it.spliterator(), false)
						                 .collect(Collectors.toList());
				    System.err.println(list);
				    
		System.err.println("=============================="
				+ "=========================================="
				+ "===========================================");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Iterable<Doctor> it = dservice.getCustomersByIds(List.of (1,2,953,952));
			StreamSupport.stream(it.spliterator(), false)
		    .map(doc -> "Doctor " + doc.getDocId() + ": " + doc.getDocName())
		    .forEach(System.err::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("============================="
				+ "======================================="
				+ "======================================="
				+ "=======================================");
		
		try {
			String theDoctor = dservice.findTheDoctor(953);
			Doctor theSecondDoctor = dservice.findDoctor(953);
			System.err.println(theDoctor);
			System.err.println(theSecondDoctor);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		
	}

}
