package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	
	public List<Doctor> findByDocNameEquals(String name);
	public List<Doctor> findByDocName(String name);
	public List<Doctor> findByDocNameIs(String name);
	
	public List<Doctor> getByDocNameEquals(String name);
	public List<Doctor> getByDocName(String name);
	public List<Doctor> getByDocNameIs(String name);
	
	public List<Doctor> readByDocNameEquals(String name);
	public List<Doctor> readByDocName(String name);
	public List<Doctor> readByDocNameIs(String name);
}
