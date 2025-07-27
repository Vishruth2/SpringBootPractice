package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "JPA_DOCTOR_TAB")
//@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	@Column(name = "DOC_ID")
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "DOCV_SEQ",initialValue = 400,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Integer docId;
	
	@Column(length = 20,name = "DOC_NAME")
	private String docName;
	
	@Column(name = "SPECIALIZATION",length = 20)
	private String specialization;
	
	
	@Column(name = "INCOME")
	private Double income;
}
