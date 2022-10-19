package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
}
