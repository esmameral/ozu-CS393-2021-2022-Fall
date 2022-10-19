package com.student.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String name;
	private List<Enrollment> enrollments= new ArrayList<Enrollment>();
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name.toUpperCase();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	



	public List<Enrollment> getEnrollments() {
		return enrollments;
	}



	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

}
