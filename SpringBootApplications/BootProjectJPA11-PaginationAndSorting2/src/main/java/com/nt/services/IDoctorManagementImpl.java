package com.nt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class IDoctorManagementImpl implements IDoctorManagementService {
    @Autowired
    private IDoctorRepository docRepo;

    @Override
    public Iterable<Doctor> getAllDoctor(boolean ascOrder, String... properties) {
        // Create a Sort object based on the provided order and properties
        Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, properties);
        
        // Fetch and return the sorted list of doctors
        Iterable<Doctor> it = docRepo.findAll(sort);
        System.err.println(it);
        return it;
    }

	@Override
	public Page<Doctor> showDoctorInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String properties) {
		//prepare the sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		//prepare Pageable object
		Pageable pageable= PageRequest.of(pageNo, pageSize, sort);
		//use the repo
		Page<Doctor> page=docRepo.findAll(pageable);
		return page;
	}

	@Override
	public void showDoctorPageByPage(int pageSize) {
		//get total records count
		long count= docRepo.count();
		//get pages count
		long pagesCount=count/pageSize;
		pagesCount=(count%pageSize==0)?pagesCount:pagesCount++;
		for (int i = 0; i < pagesCount; i++) {
			//prepare Pageable object
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Doctor> page = docRepo.findAll(pageable);
			
			page.forEach(System.err::println);
			System.err.println("========================"+(page.getNumber()+1)+" / "+page.getTotalPages()+"========================");
		}
		
		
	}
	
	
}
