package com.student.service;

import java.util.List;

import com.student.model.Course;
import com.student.model.dto.CourseDTO;

public interface CourseService {
	public CourseDTO save(CourseDTO courseDTO);
	public Course findByCode(String code);
	public List<Course> getByInstructorId(int id);
	public Course getByInstructorIdAndCourseId(int instructorId, int courseId);
	public List<Course> getAll();
	public void delete(int id);

}
