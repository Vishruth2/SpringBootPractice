package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.services.IDoctorManagementService;

@Component
public class PaginationAndSortingRunner implements CommandLineRunner {

	@Autowired
	private IDoctorManagementService dservice;
	@Override
	public void run(String... args) throws Exception {
		//dservice.getAllDoctor(true, "income").forEach(System.out::println);
		System.err.println("==========================findAll(Pageable pageable)==========================");
//		try {
////			dservice.showDoctorInfoByPageNo(2, 3, false, "docId").getContent().forEach(System.err::println);
			Page<Doctor> page=dservice.showDoctorInfoByPageNo(2, 3, false, "docId");
			System.err.println("Page number ::"+page.getNumber());
//			System.err.println("Page count ::"+page.getTotalPages());
//			System.err.println("is it first Page ::"+page.isFirst());
//			System.err.println("is it Last Page :: "+page.getSize());
//			System.err.println("page size :: "+page.getNumberOfElements());
//			if (!page.isEmpty()) {
//				List<Doctor> list=page.getContent();
//				list.forEach(System.err::println);
//			} else {
//				System.err.println("No page found");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			dservice.showDoctorPageByPage(3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
