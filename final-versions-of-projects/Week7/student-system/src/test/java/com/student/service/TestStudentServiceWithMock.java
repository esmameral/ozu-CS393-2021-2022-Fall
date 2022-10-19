package com.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.model.Assessment;
import com.student.model.AssessmentType;
import com.student.model.Course;
import com.student.model.Enrollment;
import com.student.model.Score;
import com.student.model.Student;
import com.student.repository.StudentRepository;

@SpringBootTest
class TestStudentServiceWithMock {
	
	@Autowired
	StudentService studentService;
	
	@MockBean
	StudentRepository studentRepo;
	
	
	@Test
	void gradeCalculationSuccess() {
		
//		Student student = createStudent();
//		Mockito.when(studentRepo.getById(1)).thenReturn(student);
//		
//		double grade = studentService.calculateGrade(1,"CS393");
//		assertEquals(84.9, grade);
//		Mockito.verify(studentRepo, times(1)).findById(1);	
//		
//		String letterGrade = studentService.calculateLetterGradeFor(grade);
//		assertEquals("A-",letterGrade);
//		Mockito.verify(studentRepo, times(1)).findById(1);
	}
	
	
	private static Student createStudent() {
		// Student
		Student student = new Student(1, "Hasan");

		// Assessments
		Assessment homework = new Assessment();
		homework.setType(AssessmentType.Homework);
		homework.setWeight(10);

		Assessment quiz = new Assessment();
		quiz.setType(AssessmentType.Quiz);
		quiz.setWeight(5);

		Assessment midterm = new Assessment();
		midterm.setType(AssessmentType.Midterm);
		midterm.setWeight(35);

		Assessment project = new Assessment();
		project.setType(AssessmentType.Project);
		project.setWeight(50);

		// Course
		Course course = new Course();
		course.setId(1);
		course.setCode("CS393");
		course.getAssessments().add(quiz);
		course.getAssessments().add(homework);
		course.getAssessments().add(midterm);
		course.getAssessments().add(project);

		// Score
		Score score1 = new Score();
		score1.setValue(89);
		score1.setAssessment(quiz);

		Score score2 = new Score();
		score2.setValue(72);
		score2.setAssessment(homework);

		Score score3 = new Score();
		score3.setValue(95);
		score3.setAssessment(midterm);

		Score score4 = new Score();
		score4.setValue(100);
		score4.setAssessment(project);

		Enrollment enrollment = new Enrollment();
		enrollment.setCourse(course);
		enrollment.setId(1);
		enrollment.getScores().add(score1);
		enrollment.getScores().add(score2);
		enrollment.getScores().add(score3);
		enrollment.getScores().add(score4);

		student.getEnrollments().add(enrollment);
		return student;
	}
	
	

}
