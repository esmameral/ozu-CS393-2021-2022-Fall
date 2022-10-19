package com.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@SpringBootApplication
@RestController
public class Application {
	@Autowired
	StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@RequestMapping("/")
	public String sayHello() {
		List<Student> list=studentService.findAll();
		StringBuffer sb=new StringBuffer();
		for (Student student : list) {
			sb.append(student);
		}
		return sb.toString();
	}
}
