package com.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Person;
import com.student.model.Student;

@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {
	private List<Student> studentList = new ArrayList<Student>();

	public Application() {
		super();
		init();
	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
	public String home() {
		StringBuffer buffer=new StringBuffer();
		

		for (Person student : studentList) {
			buffer.append(student.getName());
			buffer.append("-");
		}
		return buffer.toString();
	}

	@RequestMapping("/sayHello")
	public String sayHello() {
		return "Hello CS393!";
	}

	private void init() {
		Student student1 = new Student(1, "Ali Sever");
		Student student2 = new Student(12, "Hasan Karaca");
		Student student3 = new Student(34, "Abdullah Kara");
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(".... APPLICATION STARTED.....");

	}

}
