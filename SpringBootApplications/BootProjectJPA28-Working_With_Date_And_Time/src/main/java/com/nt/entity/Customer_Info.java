package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Customer_Info")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer_Info {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer cno;
	
	@NonNull
	@Column(length = 25)
	private String custName;
	@NonNull
	@Column(length = 25)
	private String custAddress;
	@NonNull
	private LocalDateTime dateOfBirth;
	@NonNull
	private LocalTime timeOfPurchase;
	@NonNull
	private LocalDate dateOfPurchase;
	
}
