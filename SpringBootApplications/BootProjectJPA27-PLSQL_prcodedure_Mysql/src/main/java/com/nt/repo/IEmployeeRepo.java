package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee_info;

public interface IEmployeeRepo extends JpaRepository<Employee_info, Integer> {

}
