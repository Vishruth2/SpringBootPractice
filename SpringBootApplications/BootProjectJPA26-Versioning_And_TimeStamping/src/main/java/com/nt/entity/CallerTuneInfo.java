package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CALLER_TUNE_INFO_TAB")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CallerTuneInfo {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer tuneId;
	
	@Column(length=40)
	@NonNull
	private String tuneName;
	
	@Column(length=40)
	@NonNull
	private String movieName;
	
	//versioning
	@Version
	@Column(name = "UPDATE_COUNT")
	private Integer updatedCount;
	
	//TimeStamp feature (Insertion date,time)
	@CreationTimestamp
	@Column(name = "SERVICE_OPTED_ON")
	private LocalDateTime serviceOptedOn;
	
	//TimeStamp feature (lastly updated date,time)
	@UpdateTimestamp
	@Column(name = "LASTLY_UPDATED_ON")
	private LocalDateTime lastlyUpdatedOn;
	
}
