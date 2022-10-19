package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Course;
import com.student.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@GetMapping()
	public List<Course> getAll(){
		return courseService.getAll();
	}
	
	@PostMapping()
	public Course addCourse(@RequestBody Course course){
		return courseService.save(course);
	}

}
