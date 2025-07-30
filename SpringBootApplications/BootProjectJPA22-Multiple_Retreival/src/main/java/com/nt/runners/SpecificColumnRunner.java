package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorMgmtService;

@Component
public class SpecificColumnRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService docService;
	
	@Override
	public void run(String... args) throws Exception {
		//Single Record retrieval
		/*
		try {
			Doctor d=docService.searchDoctorByDocName("harshitha");
			System.err.println("Doctor Infor :: "+d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//Multiple Column Retrieval
		/*
		try {
			List<Object[]> list = docService.searchDoctorBySpecialization("Mentalist");
			list.stream().map(row->{
				Integer id=(Integer)row[0];
				String name =String.valueOf(row[1]);
				String specialization = (String)row[2];
				return "Doctor Id:"+id+"Doctor Name: " + name + ", Specialization: " +specialization;
			}).forEach(System.err::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//Single Column Retrieval
		try { 
			List<String> list=docService.searchDoctorNameBySpecialization("Mentalist");
			
			list.stream().map(row->String.valueOf(row)).forEach(System.err::println);;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
