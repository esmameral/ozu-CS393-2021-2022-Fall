package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	public Course findByCode(String code);

	@Modifying
	@Query("update Course c set c.instructor=null where c.instructor.id=?1")
	public void unassignInstructor(int courseId);

	public List<Course> getByInstructorId(int id);

	@Query("select c from Course c inner join c.instructor i where i.id=?1 and c.id=?2")
	public Course getByInstructorIdAndCourseId(int instructorId, int courseId);

}
