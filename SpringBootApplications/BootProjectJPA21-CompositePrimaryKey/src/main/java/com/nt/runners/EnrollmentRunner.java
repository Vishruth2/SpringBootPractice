package com.nt.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.StudentCourse;
import com.nt.entity.StudentCourseId;
import com.nt.repository.EnrollmentRepository;

@Component
public class EnrollmentRunner implements CommandLineRunner {

	@Autowired
	private EnrollmentRepository enRepo;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			//Insertion of data
			enRepo.save(new StudentCourse(1L,101L,LocalDate.of(2025, 7, 1),"A"));
			enRepo.save(new StudentCourse(1L, 102L, LocalDate.of(2025, 7, 2), "B"));
			enRepo.save(new StudentCourse(2L, 101L, LocalDate.of(2025, 7, 3), "A-"));
			enRepo.save(new StudentCourse(2L, 102L, LocalDate.of(2025, 7, 4), "B+"));
			enRepo.save(new StudentCourse(2L, 103L, LocalDate.of(2025, 7, 3), "B+"));
			enRepo.save(new StudentCourse(3L, 102L, LocalDate.of(2025, 7, 4), "B+"));
			enRepo.save(new StudentCourse(3L, 101L, LocalDate.of(2025, 7, 4), "A+"));
			
			//Read All the enrollments
			enRepo.findAll().forEach(sc ->{
				System.err.println("Student Id : "+sc.getStudentId()+""
						+ "\n"+" Course Id : "+sc.getCourseId()+""
								+ "\n"+" Date : "+sc.getEnrollmentDate()+""
										+ " \n"+" Grade : "+sc.getGrade());
			});
			
			
			
			//Read by student Id
			System.err.println("\n===============Reading Enrollments for Specific Student==========================\n");
			enRepo.findByStudentId(2L).forEach(sc ->{
				System.err.println("Student Id : "+sc.getStudentId()+""
						+ "\n"+" Course Id : "+sc.getCourseId()+""
								+ "\n"+" Date : "+sc.getEnrollmentDate()+""
										+ " \n"+" Grade : "+sc.getGrade());
			});
			
			//Read by course Id
			System.err.println("\n===============Reading Enrollments for Specific course==========================\n");
			
			enRepo.findByCourseId(101L).forEach(sc ->{
				System.err.println("Student Id : "+sc.getStudentId()+""
						+ "\n"+" Course Id : "+sc.getCourseId()+""
								+ "\n"+" Date : "+sc.getEnrollmentDate()+""
										+ " \n"+" Grade : "+sc.getGrade());
			});
			
			//Count Enrollments by course 
			System.err.println("\n===============Counting Number of Enrollments==========================\n");
			long count = enRepo.countByCourseId(101L);
			System.err.println("Number of students enrolled in Course : 101 are "+count);
			
			//Read by Date Range 
			System.err.println("\n===============Reading Enrollments for Specific date==========================\n");
			enRepo.findByEnrollmentDateBetween(LocalDate.of(2025, 7, 1), LocalDate.of(2025, 7, 4)).forEach(sc ->{
				System.err.println("Student Id : "+sc.getStudentId()+""
						+ "\n"+" Course Id : "+sc.getCourseId()+""
								+ "\n"+" Date : "+sc.getEnrollmentDate()+""
										+ " \n"+" Grade : "+sc.getGrade());
			});
		
			
//			//Update Grade 
			System.err.println("\n===============Updating Grade For Specific Student==========================\n");
			int update = enRepo.updateGrade(2L, 101L, "O");
			System.err.println("Updated "+update+" enrollment");
			StudentCourse updatedEnrollment=enRepo.findById(new StudentCourseId(2L, 101L)).orElse(null);
			if (updatedEnrollment!=null) {
				System.err.println("New Grade : "+updatedEnrollment.getGrade());
			}
		
			//Delete By composite Key
			System.err.println("\n===============Deleting  Specific Student==========================\n");
			enRepo.deleteByStudentId(3L);
			boolean exists = enRepo.isExist(3L);
			if (!exists) {
				System.err.println("Deleted Successfully");
			} else {
				System.err.println("Not Deleted Successfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
