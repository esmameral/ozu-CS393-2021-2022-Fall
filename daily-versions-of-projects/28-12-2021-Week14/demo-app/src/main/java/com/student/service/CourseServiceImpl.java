package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Course;
import com.student.model.Instructor;
import com.student.model.dto.CourseDTO;
import com.student.repository.CourseRepository;
import com.student.repository.InstructorRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	InstructorRepository instructorRepository;
	
	@Override
	public List<Course> getAll() {
		return courseRepository.findAll();
	}
	
	@Override
	public CourseDTO save(CourseDTO courseDTO) {
		Course course = new Course();
		Instructor ins= instructorRepository.getById(courseDTO.getInstructorId());
		course.setCode(courseDTO.getCode());
		course.setName(courseDTO.getName());
		course.setCredit(courseDTO.getCredit());
		
		course.setCourseType(courseDTO.getCourseType());
		course.setInstructor(ins);
		courseRepository.save(course);
		courseDTO.setId(course.getId());
		return courseDTO;
	}
	
	public void delete(int id) {
		courseRepository.deleteById(id);
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
