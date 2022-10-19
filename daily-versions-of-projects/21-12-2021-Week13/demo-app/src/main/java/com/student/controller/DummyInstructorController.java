package com.student.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Course;
import com.student.model.Instructor;

@RestController
@RequestMapping("/dummy/instructors")
public class DummyInstructorController {
	private Map<Integer, Instructor> instructors=new HashMap<>();

	public DummyInstructorController() {
		super();
		Course course1 = new Course();
		course1.setId(1);
		course1.setCode("CS101");
		course1.setName("Computer Programming");
		course1.setFaculty("Computer Science");
		
		Course course2 = new Course();
		course2.setId(2);
		course2.setCode("CS202");
		course2.setName("Database Management Systems");
		course2.setFaculty("Computer Science");
		
		Course course3 = new Course();
		course3.setId(3);
		course3.setCode("CS102");
		course3.setName("Object Oriented Programming");
		course3.setFaculty("Computer Science");
		
		Instructor ins1=new Instructor();
		ins1.setId(1);
		ins1.setName("Ece Demir");
		
		Instructor ins2=new Instructor();
		ins2.setId(2);
		ins2.setName("Kaya Eker");
		
		ins1.getCourses().add(course1);
		course1.setInstructor(ins1);
		ins1.getCourses().add(course2);
		course2.setInstructor(ins2);
		
		ins2.getCourses().add(course3);
		course3.setInstructor(ins2);
		
		instructors.put(ins1.getId(), ins1);
		instructors.put(ins2.getId(), ins2);
	}
	
	
	@GetMapping
	public List<Instructor> getAll(){
		return new ArrayList<Instructor>(instructors.values());
	}
	
	@GetMapping("/{instructor-id}")
	public Instructor getInstructorById(@PathVariable("instructor-id") int id){
		Collection<Instructor> list= instructors.values();
		for (Instructor instructor : list) {
			if(instructor.getId()==id)
				return instructor;
				
		}
		
		return null; 
	}
	
	@GetMapping("/{instructor-id}/courses")
	public List<Course> getCoursesByInstructorId(@PathVariable("instructor-id") int id){
		Collection<Instructor> list= instructors.values();
		for (Instructor instructor : list) {
			if(instructor.getId()==id)
				return instructor.getCourses();
				
		}
		
		return null; 
	}
	
	
	@GetMapping("/{instructor-id}/courses/{course-id}")
	public Course getCoursesByInstructorId(@PathVariable("instructor-id") int instructorId, @PathVariable("course-id") int courseId){
		Collection<Instructor> list= instructors.values();
		for (Instructor instructor : list) {
			if(instructor.getId()==instructorId)
				for (Course course : instructor.getCourses()) {
					if(course.getId()==courseId)
						return course;
				}
				
		}
		
		return null; 
	}
	
	@DeleteMapping("/{instructor-id}")
	public void deleteById(@PathVariable("instructor-id") int id){
		instructors.remove(id);
		
	}
	
	@PostMapping
	public Instructor saveInstructor(@RequestBody Instructor data){
		instructors.put(data.getId(), data);
		return data;
	}
	
}
