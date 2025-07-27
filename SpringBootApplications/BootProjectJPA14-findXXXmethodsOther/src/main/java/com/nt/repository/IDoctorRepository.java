package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	public Iterable<Doctor> findByDocNameStartingWith(String initialChar);
	public Iterable<Doctor> findByDocNameEndingWith(String lastChar);
	public Iterable<Doctor> findByDocNameContaining(String chars);
	public Iterable<Doctor> findByDocNameEqualsIgnoreCase(String name);
//	public Iterable<Doctor> findByContainingIgnoreCase(String chars);
	public Iterable<Doctor> findByDocNameLike(String name);
	
}
