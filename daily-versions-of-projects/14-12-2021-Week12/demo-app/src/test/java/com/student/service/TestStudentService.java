package com.student.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Assessment;
import com.student.model.AssessmentType;
import com.student.model.Course;
import com.student.model.Enrollment;
import com.student.model.Instructor;
import com.student.model.Person;
import com.student.model.Score;
import com.student.model.Student;

@SpringBootTest
class TestStudentService {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	InstructorService instructorService;
	
	@Test
	public void testCreateInstructor() {
		
		Instructor ins=new Instructor();
		ins.setName("HASAN SOZER");
		instructorService.save(ins);
		
		//assertTrue(ins.getId()>0);
		
		Course course= new Course();
		course.setCode("CS202");
		course.setFaculty("CS");
		course.setName("Database Programming");
		assertTrue(course.getId()==0);
		ins.getCourses().add(course);
		
		course.setInstructor(ins);
		instructorService.save(ins);	

		
	}
	
	
	
	
//	@MockBean
//	StudentRepository studentRepo;
	
	@Test
	public void testSaveStudent() {
		long count1=studentService.studentCount();
		System.out.println("Count1:"+count1);
		Student student=new Student();
		student.setName("HASAN KARACA");
		assertTrue(student.getId()==0);
		
		studentService.save(student);
		assertTrue(student.getId()>0);
		long count2=studentService.studentCount();
		System.out.println("Count2:"+count2);
		assertTrue(count2==count1+1);
		
		
		
		Course course= new Course();
		course.setCode("CS393");
		course.setFaculty("CS");
		course.setName("Developing Backend Applications");
		assertTrue(course.getId()==0);
		
		courseService.save(course);
		assertTrue(course.getId()>0);
		
		Course c=courseService.findByCode("CS393");
		assertTrue(c.getId()>0);
		System.out.println(c.getCode()+" "+c.getName());
		
	}
	
	@Test
	void gradeCalculationSuccess() {
//		Student student = createStudent();
//		Mockito.when(studentRepo.findById(1)).thenReturn(student);
//		
//		double grade = studentService.calculateGradeFor(1,"CS393");
//		assertEquals(84.9, grade);
//		Mockito.verify(studentRepo, times(1)).findById(1);	
//		
//		String letterGrade = studentService.calculateLetterGradeFor(grade);
//		assertEquals("A-",letterGrade);
//		Mockito.verify(studentRepo, times(1)).findById(1);
	}
	
	
	private static Person createStudent() {
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
