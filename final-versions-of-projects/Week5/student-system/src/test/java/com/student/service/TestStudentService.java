package com.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.model.Assessment;
import com.student.model.AssessmentType;
import com.student.model.Course;
import com.student.model.Enrollment;
import com.student.model.Score;
import com.student.model.Student;
import com.student.repository.StudentRepository;

@SpringBootTest
class TestStudentService {
	
	@Autowired
	StudentService studentService;
	
	
	@Test
	void testSaveAndFind() {
		long studentCountBefore=studentService.studentCount();
		Student firstStudent=new Student("Esma Meral");
		assertTrue(firstStudent.getId()==0, "Id should be 0");
		firstStudent= studentService.save(new Student("Esma"));
		assertTrue(firstStudent.getId()>0, "Id is still 0");
		long studentCountAfter=studentService.studentCount();
		assertTrue(studentCountBefore+1==studentCountAfter);
	}
	
	
	
	

}
