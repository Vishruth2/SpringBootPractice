package com.nt.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer_Info;
import com.nt.service.ICustomerMgmt;

@Component
public class CustomerRunners implements CommandLineRunner {
	
	@Autowired
	private ICustomerMgmt dservice;

	@Override
	public void run(String... args) throws Exception {
		try {
			//insert Data
			Customer_Info customer1 = new Customer_Info(
					"Alice Smith", "456 Elm St", 
					LocalDateTime.of(1985, 7, 10, 8, 0),
					LocalTime.now(), 
					LocalDate.now()
					);
			
			Customer_Info customer2 = new Customer_Info(
					"Bob Johnson",
					"789 Oak Ave",
					LocalDateTime.of(1978, 3, 22, 16, 20), 
					LocalTime.of(16, 30), 
					LocalDate.of(2025, 7, 30)
					);
			
			Customer_Info customer3 = new Customer_Info(
					"Carol White", "321 Pine Rd", 
					LocalDateTime.of(2000, 1, 1, 12, 0), 
					LocalTime.of(11, 45), 
					LocalDate.of(2025, 8, 2)
					);
			
			Customer_Info customer4 = new Customer_Info(
				    "David Brown", 
				    "22 Maple Blvd", 
				    LocalDateTime.of(1992, 9, 5, 14, 10), 
				    LocalTime.of(13, 30), 
				    LocalDate.of(2025, 7, 28)
				);

				Customer_Info customer5 = new Customer_Info(
				    "Emma Wilson", 
				    "88 Cherry Lane", 
				    LocalDateTime.of(1988, 11, 20, 9, 45), 
				    LocalTime.of(10, 5), 
				    LocalDate.of(2025, 8, 2)
				);

				Customer_Info customer6 = new Customer_Info(
				    "Frank Thomas", 
				    "19 Birch Way", 
				    LocalDateTime.of(1995, 2, 14, 7, 0), 
				    LocalTime.of(12, 0), 
				    LocalDate.of(2025, 7, 31)
				);

				Customer_Info customer7 = new Customer_Info(
				    "Grace Lee", 
				    "500 Sunset Drive", 
				    LocalDateTime.of(2001, 6, 3, 18, 25), 
				    LocalTime.of(15, 15), 
				    LocalDate.of(2025, 8, 1)
				);

				Customer_Info customer8 = new Customer_Info(
				    "Henry Adams", 
				    "77 Sunrise Ave", 
				    LocalDateTime.of(1980, 12, 31, 22, 50), 
				    LocalTime.of(9, 30), 
				    LocalDate.of(2025, 7, 29)
				);

				Customer_Info customer9 = new Customer_Info(
				    "Isabella Clark", 
				    "135 Forest Hill", 
				    LocalDateTime.of(1999, 4, 27, 13, 15), 
				    LocalTime.of(17, 40), 
				    LocalDate.of(2025, 8, 2)
				);

				Customer_Info customer10 = new Customer_Info(
				    "Jack Martin", 
				    "61 Ocean View", 
				    LocalDateTime.of(1975, 8, 19, 11, 0), 
				    LocalTime.of(16, 55), 
				    LocalDate.of(2025, 7, 30)
				);

				List<Customer_Info> customers = List.of(
					     customer2, customer3, 
					    customer4, customer5, customer6, 
					    customer7, customer8, customer9, customer10
					);
				
				dservice.registerAllCustomer(customers).forEach(System.err::println); 
			
//			String result=dservice.registerCustomer(customer1);
//			System.err.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
