package com.nt.service;

import java.util.List;

import com.nt.entity.Customer_Info;

public interface ICustomerMgmt {
	public String registerCustomer(Customer_Info cust);
	public List<Customer_Info> getAllCustomers();
	
	public List<Customer_Info> registerAllCustomer(List<Customer_Info> cust);
}
