package com.student.service;

import java.util.List;

import com.student.model.Instructor;
import com.student.model.dto.InstructorDTO;

public interface InstructorService {
	public Instructor save(Instructor instructor);
	public  List<InstructorDTO>  getAll(String orderBy);
	public Instructor getById(int id);
	public void deleteById(int id);
	
}
