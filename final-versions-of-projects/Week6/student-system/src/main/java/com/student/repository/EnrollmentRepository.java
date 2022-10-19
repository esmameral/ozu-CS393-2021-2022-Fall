package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

}
