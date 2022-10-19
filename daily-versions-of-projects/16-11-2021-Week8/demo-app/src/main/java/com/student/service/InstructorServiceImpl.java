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

	@Override
	public Instructor save(Instructor ins) {
		for (Course course : ins.getCourses()) {
			courseRepository.save(course);
	
		}
		
		return instructorRepository.save(ins);
	}
	

}
