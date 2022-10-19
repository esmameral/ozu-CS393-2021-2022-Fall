package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Course;
import com.student.model.Instructor;
import com.student.model.dto.InstructorDTO;
import com.student.service.CourseService;
import com.student.service.InstructorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
	
	@Autowired
	InstructorService instructorService;
	
	@Autowired 
	CourseService courseService;
	

	@GetMapping
	
	
	@Operation(summary = "get all instructors", description = "You can read all information about instructors. You can order instructors by name or id")
	    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
	public List<InstructorDTO> getAll(
			@Parameter(description="You can sort instructors by name or id. Id cannot be empty. Default value is id", required=false)
			@RequestParam(value = "sort", required = false, defaultValue = "id") String orderBy){
	
		return instructorService.getAll(orderBy);
	}
	
	@GetMapping("/{instructor-id}")
	public Instructor getInstructorById(@PathVariable("instructor-id") int id){
		return instructorService.getById(id); 
	}
	
	@GetMapping("/{instructor-id}/courses")
	public List<Course> getCoursesByInstructorId(@PathVariable("instructor-id") int id){
		return courseService.getByInstructorId(id); 
	}
	
	
	@GetMapping("/{instructor-id}/courses/{course-id}")
	public Course getCoursesByInstructorId(@PathVariable("instructor-id") int instructorId, @PathVariable("course-id") int courseId){
		return courseService.getByInstructorIdAndCourseId(instructorId, courseId); 
	}
	
	@DeleteMapping("/{instructor-id}")
	public void deleteById(@PathVariable("instructor-id") int id){
		instructorService.deleteById(id);
		
	}
	
	@PostMapping
	public Instructor saveInstructor(@RequestBody Instructor data){
		
		return instructorService.save(data);
	}
	
	
}
