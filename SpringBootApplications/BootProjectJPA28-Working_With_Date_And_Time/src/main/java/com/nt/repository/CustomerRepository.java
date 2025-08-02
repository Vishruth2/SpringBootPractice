package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer_Info;

public interface CustomerRepository extends JpaRepository<Customer_Info, Integer> {

}
