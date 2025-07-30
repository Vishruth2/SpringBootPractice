package com.nt.entity;

import java.io.Serializable;
import java.util.Objects;

public class StudentCourseId implements Serializable {
	private Long studentId;
	private Long courseId;
	
	public StudentCourseId() {
		
	}
	
	public StudentCourseId(Long studentId, Long courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourseId other = (StudentCourseId) obj;
		return Objects.equals(courseId, other.courseId) && Objects.equals(studentId, other.studentId);
	}
	
	
	
}
