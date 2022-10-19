package com.student.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.model.Course;
import com.student.model.Enrollment;
import com.student.model.Instructor;
import com.student.model.Student;

@SpringBootTest

class TestStudentService {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	InstructorService instructorService;
	
	@Test
	void testSaveInstructor() {
		Instructor instructor=new Instructor();
		instructor.setName("ESMA MERAL");
		instructorService.save(instructor);
		assertTrue(instructor.getId()>0);
	}
	
	@Test
	void testSaveInstructorAndAssignCourse() {
		Instructor instructor=new Instructor();
		instructor.setName("ECE MERAL");
		instructor.setOfficeHours("wednesday 09.00-11:00");
		instructor.setOfficeNumber("221");
		instructorService.assignCourse(instructor,"CS393");
		assertTrue(instructor.getId()>0);
	}
	
	@Test
	void testSaveAndDeleteStudent() {
		long firstCount, lastCount;
		firstCount=studentService.studentCount();
		Student firstStudent=new Student("Esma Meral");
		assertTrue(firstStudent.getId()==0, "Id should be 0");
		
		firstStudent= studentService.save(firstStudent);
		assertTrue(firstStudent.getId()>0, "Id is still 0");
		lastCount=studentService.studentCount();
		assertTrue(firstCount+1==lastCount);
		
		Student secondStudent=new Student("Hasan Karaca");
		firstCount=studentService.studentCount();
		studentService.save(secondStudent);
		assertTrue(secondStudent.getId()>0, "second student id should be greater than 0");
		lastCount=studentService.studentCount();
		assertTrue(firstCount+1==lastCount);
		
		firstCount=studentService.studentCount();
		studentService.delete(secondStudent.getId());
		lastCount=studentService.studentCount();
		
		assertTrue(firstCount-1==lastCount);		
		
		
	}
	
	@Test
	void testEnrollStudentToCourse() {
		Student student=new Student("Tuna Demir");
		assertTrue(student.getId()==0, "Id should be 0");
		student= studentService.save(student);
		assertTrue(student.getId()>0, "Id is still 0");
		
		Course course=new Course();
		course.setCode("CS393");
		course.setName("Developing Backend Applications with SpringFramework");
		course.setFaculty("CS");
		courseService.save(course);
		
		Enrollment enrollment=new Enrollment();
		enrollment.setCourse(course);
		enrollment.setGrade(95);
		enrollment.setLetterGrade("A");
		List<Enrollment> enrollments=new ArrayList<>();
		enrollments.add(enrollment);
		student.setEnrollments(enrollments);
		studentService.save(student);
		
		
		
	}
	
	

}
