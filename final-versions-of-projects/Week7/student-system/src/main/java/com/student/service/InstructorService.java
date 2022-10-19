package com.student.service;

import com.student.model.Instructor;

public interface InstructorService {

	public Instructor save(Instructor instructor);

	Instructor assignCourse(Instructor instructor, String courseCode);

}
