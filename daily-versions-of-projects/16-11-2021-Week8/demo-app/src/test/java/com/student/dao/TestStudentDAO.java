package com.student.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.model.Person;
import com.student.model.Student;

@SpringBootTest
class TestStudentDAO {
	
	@Autowired
	StudentDAO studentDAO;
	
	
	@Test
	public void testStudentDAO() {
		long count=studentDAO.count();
		System.out.println(count);
		assertTrue(count==3);
		List<Student> list=studentDAO.findAll();
		assertTrue(list.size()==3);
		for (Person student : list) {
			System.out.println(student);
		}
		
		
		
		
	}
	
	
	
	

}
