package com.student.model.repository;

import com.student.model.Student;

public interface StudentRepository {
	public Student findById(int id);
}
