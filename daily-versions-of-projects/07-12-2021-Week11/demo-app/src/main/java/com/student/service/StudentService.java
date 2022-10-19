package com.student.service;

import java.util.List;

import com.student.model.Person;
import com.student.model.Student;

public interface StudentService {
	
	
	public Person save(Student student);
	public long studentCount()	;
	public void delete(int id);
	public Person findById(int id);
	public List<Student> findAll() ;
	
}
