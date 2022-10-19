package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	
	public double calculateGradeFor(int studentId, String courseCode) ;
	public String calculateLetterGradeFor(double grade);
	public List<Student> findAll();
	public Student save(Student student);
	long studentCount();

}
