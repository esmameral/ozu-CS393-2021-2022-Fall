package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Course;
import com.student.model.Instructor;
import com.student.repository.CourseRepository;
import com.student.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	InstructorRepository instructorRepository;
	@Autowired
	CourseRepository courseRepository;

	public Instructor save(Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	
	@Override
	public Instructor assignCourse(Instructor instructor,String courseCode) {
		Course course=courseRepository.findByCode(courseCode);
		course.setInstructor(instructor);
		instructor.getCourses().add(course);
		instructorRepository.save(instructor);
		return instructor;
		
		
	}
}
