package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Enrollment;
import com.student.model.Student;
import com.student.repository.EnrollmentRepository;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	@Qualifier("studentRepository")
	StudentRepository studentRepo;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	

	@Override
	@Transactional(readOnly = true)
	public void calculateGrade(int studentId, String courseCode) {	
		Object[][] result=enrollmentRepository.calculateGrade(courseCode,studentId);
		double grade =(double) result[0][0];
		int enrollmentId=(int) result[0][1];
		String letter = calculateLetterGrade(grade);
		System.out.println(" ------------- grade:"+grade+" Letter:"+letter);
		System.out.println("enrollmentId:"+enrollmentId);
		enrollmentRepository.updateGrades(enrollmentId, grade,letter);
	}
	public Student save(Student student) {
		for (Enrollment e : student.getEnrollments()) {
			enrollmentRepository.save(e);
		}
		
		return studentRepo.save(student);
	}
	
	@Override
	public void delete(int id) {
		studentRepo.deleteById(id);
	}
	
	@Override
	public List<Student> findByCourseCode(String code) {
		return studentRepo.findByCourseCode(code);
	}
	
	@Override
	public Student findById(int id) {
		return studentRepo.getById(id);
	}
	
	@Override
	public long studentCount() {
		return studentRepo.count();
	}
	
	

	private String calculateLetterGrade(double grade) {

		if (grade >= 90)
			return "A";
		else if (grade >= 80)
			return "A-";
		else if (grade >= 75)
			return "B+";
		else if (grade >= 70)
			return "B";
		else if (grade >= 65)
			return "B-";
		else if (grade >= 60)
			return "C+";
		else if (grade >= 56)
			return "C";
		else if (grade >= 51)
			return "C-";
		else if (grade >= 46)
			return "D+";
		else if (grade >= 40)
			return "D";
		else
			return "F";
	}


	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

}
