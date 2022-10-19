package com.student.service;

import java.util.List;

import com.student.model.Course;

public interface CourseService {
	public Course save(Course course);
	public Course findByCode(String code);
	public List<Course> getByInstructorId(int id);
	Course getByInstructorIdAndCourseId(int instructorId, int courseId);

}
