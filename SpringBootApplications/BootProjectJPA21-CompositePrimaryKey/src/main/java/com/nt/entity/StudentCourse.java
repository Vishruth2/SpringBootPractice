package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Student_JPA_TAB_Course")
@IdClass(value = StudentCourseId.class)
@Setter
@Getter
@AllArgsConstructor
public class StudentCourse implements Serializable {
	
	public StudentCourse() {
		
	}
	
	@Id
	private Long studentId;
	
	@Id
	private Long courseId;
	
	private LocalDate enrollmentDate;
	private String grade;
	
	
}
