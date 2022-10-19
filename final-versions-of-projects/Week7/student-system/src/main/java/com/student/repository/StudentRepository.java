package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("select distinct s from Student s inner join s.enrollments e where e.course.code=?1")
	public List<Student> findByCourseCode(String code);
	
	
}
