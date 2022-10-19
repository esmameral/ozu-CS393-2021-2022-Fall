package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Course;
import com.student.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}
	
	@Override
	public Course findByCode(String code) {
		return courseRepository.findByCode(code);
		
	}

	@Override
	public Course getByInstructorIdAndCourseId(int instructorId, int courseId) {
		return courseRepository.getByInstructorIdAndCourseId(instructorId,courseId);
	}

	@Override
	public List<Course> getByInstructorId(int id) {
		return courseRepository.getByInstructorId(id);
	}

}
