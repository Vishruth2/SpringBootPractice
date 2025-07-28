package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.BootProjectJpa17QueryMethodsSpecificColumnsApplication;
import com.nt.service.IDoctorMgmtService;

@Component
public class QueryRunners implements CommandLineRunner {

    private final BootProjectJpa17QueryMethodsSpecificColumnsApplication bootProjectJpa17QueryMethodsSpecificColumnsApplication;
	
	@Autowired
	private IDoctorMgmtService docService;

    QueryRunners(BootProjectJpa17QueryMethodsSpecificColumnsApplication bootProjectJpa17QueryMethodsSpecificColumnsApplication) {
        this.bootProjectJpa17QueryMethodsSpecificColumnsApplication = bootProjectJpa17QueryMethodsSpecificColumnsApplication;
    }
	
	@Override
	public void run(String... args) throws Exception {
		try {
			List<Object[]> list=docService.showDoctorByIncome(10000.0, 200000.0);
			//to process we have following ways
			
			//1.
			for (Object[] objects : list) {
				Integer id = (Integer)objects[0];  //docId
				String name = (String)objects[1];  //docName
				Double income = (Double)objects[2];  //income
				System.err.println("Doctor Id:"+id+"Doctor Name: " + name + ", Income: " + income);
			}
			
			System.out.println("============================================================");
			//2.
			list.forEach(row ->{
				for (Object objects : row) {
					System.err.println(objects);
				}
				System.out.println();
			});
			
			System.out.println("============================================================");
			
			//3.
			list.forEach(row->{
				System.err.println(Arrays.toString(row));
			});
			
			System.out.println("============================================================");
			
			//4.
			list.stream()
			     .map(row->{
						Integer id = (Integer)row[0];  //docId
						String name = (String)row[1];  //docName
						Double income = (Double)row[2];  //income
						return "Doctor Id:"+id+"Doctor Name: " + name + ", Income: " + income;
					})
			.forEach(System.err::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
