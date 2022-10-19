package com.student.service;

import com.student.model.Course;

public interface CourseService {
	public Course save(Course course);
	public Course findByCode(String code);
	
}
