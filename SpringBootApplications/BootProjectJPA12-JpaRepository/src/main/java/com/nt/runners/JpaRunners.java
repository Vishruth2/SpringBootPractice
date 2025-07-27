package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmt;

@Component
public class JpaRunners implements CommandLineRunner {
	@Autowired
	private IDoctorMgmt dservice;
	
	@Override
	public void run(String... args) throws Exception {
//		try {
//			String result=dservice.deleteDoctorsByIds(List.of(3,4,6));
//			System.err.println(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	
		/*
		// getReferenceById
		try {
			Doctor d =dservice.getCustomerById(1);
			System.err.println(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		//findAll(Example,sort)
		try {
			Doctor d = new Doctor();
//			d.setSpecialization("Cardiologist");
//			d.setDocName("");
//			List<Doctor> dlist =dservice.showDoctorsByExampleData(d, true, "specialization","income");
			List<Doctor> dlist =dservice.showDoctorsByExampleData(d, true, "docId");
			dlist.forEach(System.err::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		**/
		
		//saveAllFlush(-)
		try {
			Doctor d1 = new Doctor();
			d1.setDocName("Monica Belluci");
			d1.setSpecialization("cardiologist");
			d1.setIncome(452004.00);

			Doctor d2 = new Doctor();
			d2.setDocName("Scarlett Johnson");
			d2.setSpecialization("Gynaceologist");
			d2.setIncome(1052004.00);

			Doctor d3 = new Doctor();
			d3.setDocName("Elizabeth Ozlen");
			d3.setSpecialization("physician");
			d3.setIncome(152004.00);

			List<Doctor> list = List.of(d1,d2,d3);
			String msg=dservice.groupDoctorsRegistration(list);
			System.err.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
