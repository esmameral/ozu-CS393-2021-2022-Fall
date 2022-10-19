package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	
	public void calculateGrade(int studentId, String courseCode) ;
	public List<Student> findAll();
	public Student save(Student student);
	public long studentCount();
	public void delete(int id);
	public Student findById(int id);
	public List<Student> findByCourseCode(String code);

}
