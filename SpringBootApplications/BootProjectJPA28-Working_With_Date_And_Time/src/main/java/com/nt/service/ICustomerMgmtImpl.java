package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer_Info;
import com.nt.repository.CustomerRepository;

@Service
public class ICustomerMgmtImpl implements ICustomerMgmt {
	
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public String registerCustomer(Customer_Info cust) {
		Integer id=custRepo.save(cust).getCno();
		return "Customer is saved with id :"+id;
	}
	

	@Override
	public List<Customer_Info> getAllCustomers() {
		return  custRepo.findAll();
	}

	@Override
	public List<Customer_Info> registerAllCustomer(List<Customer_Info> cust) {
		List<Customer_Info> list=custRepo.saveAll(cust);
		return list;
	}



	

}
