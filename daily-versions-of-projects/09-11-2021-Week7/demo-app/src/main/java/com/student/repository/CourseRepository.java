package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	public Course findByCode(String code);
}
