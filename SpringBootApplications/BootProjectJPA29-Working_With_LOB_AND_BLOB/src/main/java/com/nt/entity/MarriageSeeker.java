package com.nt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "MARRIAGE_SEEKER")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MarriageSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@Column(length = 25)
	private String name;
	
	@NonNull
	@Column(length = 35)
	private String address;
	
	@NonNull
	@Lob
	private byte[] photo;
	
	@NonNull
	private LocalDateTime dateOfBirth;
	
	@NonNull
	@Lob
	private char[] bioData;
	
//	@NonNull
	private boolean indian;
}
