package com.student.service;

import java.util.List;

import com.student.model.Instructor;

public interface InstructorService {
	public Instructor save(Instructor instructor);
	public List<Instructor> getAll();
	public Instructor getById(int id);
	public void deleteById(int id);
	
}
