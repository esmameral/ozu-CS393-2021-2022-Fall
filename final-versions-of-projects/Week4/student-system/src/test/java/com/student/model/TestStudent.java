package com.student.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TestStudent {

	@Test
	void studentCreate() {
		Student student=new Student(1, "hasan");
		assertTrue(student.getName().equals("HASAN"),"Name is not correct");
		assertEquals(1, student.getId());
		student.setName("Kerem");
		assertTrue(student.getName().equals("KEREM"),"Name assignment is not correct");
		
		Course course = new Course();
		assertTrue(course.getId()==0);
		course.setId(1);
		assertTrue(course.getId()==1);
		
		assertNotNull(course.getStudents());
		
		
		course.setCode("CS393");
		Enrollment enrollment = new Enrollment();
		enrollment.setCourse(course);
		student.getEnrollments().add(enrollment);
		assertNotNull(course.getStudents());
		assertTrue(student.getEnrollments() != null);
		assertTrue(student.getEnrollments().size() == 1);
		assertTrue(student.getEnrollments().get(0).getCourse() != null);
		assertTrue(student.getEnrollments().get(0).getCourse().getCode().equals("CS393"));
		
		
		

		
	}
	
	


}
