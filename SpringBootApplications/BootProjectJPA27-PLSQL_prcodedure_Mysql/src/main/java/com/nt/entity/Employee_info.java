package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee_info {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer eno;
	
	@NonNull
	private String ename;
	@NonNull
	private String desg;
	@NonNull
	private Double salary;
	@NonNull
	private Double gross_salary;
	@NonNull
	private Double net_salary;
}
