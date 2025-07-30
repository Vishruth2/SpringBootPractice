package com.nt.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.StudentCourse;
import com.nt.entity.StudentCourseId;

public interface EnrollmentRepository extends JpaRepository<StudentCourse, StudentCourseId> {
	
	//Find all enrollments for a specific student
	@Query("SELECT sc FROM StudentCourse as sc WHERE sc.studentId =:studentId")
	public List<StudentCourse> findByStudentId(Long studentId);
	
	//Find all enrollments from a specific course
	public List<StudentCourse> findByCourseId(Long courseId);
	
	//count enrollments by course
	@Query("SELECT COUNT(sc) FROM StudentCourse sc WHERE courseId =:courseId")
	public long countByCourseId(Long courseId);
	
	//find enrollments within a date range 
	public List<StudentCourse> findByEnrollmentDateBetween(LocalDate startDate,LocalDate endDate);
	
	//Update grade for a specific enrollment
	@Modifying
	@Transactional
	@Query("UPDATE StudentCourse sc SET sc.grade =:grade WHERE sc.studentId =:studentId AND sc.courseId =:courseId")
	public int updateGrade(Long studentId,Long courseId,String grade);
	
	//Delete all enrollment for a specific student 
	@Modifying
	@Transactional
	@Query("DELETE FROM StudentCourse sc WHERE sc.studentId = :studentId")
	public int deleteByStudentId(Long studentId);

	//Exist  a specific student 
		@Query("SELECT COUNT(sc)>0 FROM StudentCourse sc WHERE sc.studentId = :studentId")
		public boolean isExist(Long studentId) ;
	
	

}
