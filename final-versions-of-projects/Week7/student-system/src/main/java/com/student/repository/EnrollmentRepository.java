package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.model.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	String sql = "select sum(S.VALUE*A.WEIGHT/100), MAX(E.ID)  "
			+ "from T_SCORE S, T_ASSESSMENT A, T_ENROLLMENT E, T_COURSE C  "
			+ "where A.ID=S.ASSESSMENT_ID  AND E.COURSE_ID=C.ID  AND C.CODE=?1  AND E.STUDENT_ID=?2 ";

	@Query(value = sql, nativeQuery = true)
	public Object[][] calculateGrade(String courseCode, int studentId);

	@Modifying
	@Query("update Enrollment e set e.grade=:grade, e.letterGrade=:letter where e.id=:enrollmentId")
	public void updateGrades(@Param("enrollmentId") int enrollmentId, @Param("grade") double grade,@Param("letter") String letter);

	

}
