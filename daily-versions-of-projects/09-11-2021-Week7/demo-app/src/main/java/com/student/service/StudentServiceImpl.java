package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Course;
import com.student.model.Person;
import com.student.model.Student;
import com.student.repository.CourseRepository;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	CourseRepository courseRepository ;


	
	
	public String calculateLetterGradeFor(double grade) {

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
	public Person save(Student student) {
		
		return studentRepo.save(student);
	}


	@Override
	public long studentCount() {
		return studentRepo.count();
	}


	@Override
	public void delete(int id) {
		studentRepo.deleteById(id);	
	}


	@Override
	public Person findById(int id) {
		return studentRepo.getById(id);
	}


	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}


	

}
