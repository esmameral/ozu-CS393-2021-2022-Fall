package com.student.model.service;

public interface StudentService {
	
	public double calculateGradeFor(int studentId, String courseCode) ;
	public String calculateLetterGradeFor(double grade);

}
