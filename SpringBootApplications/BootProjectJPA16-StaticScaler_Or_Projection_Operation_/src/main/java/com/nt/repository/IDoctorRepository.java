package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;
import com.nt.view.IResultView;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	public List<IResultView> findBySpecializationIn(List<String> specials);

}
