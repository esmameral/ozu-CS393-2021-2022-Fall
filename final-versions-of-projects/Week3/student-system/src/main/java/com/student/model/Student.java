package com.student.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String name;
	
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private List<Course> courses= new ArrayList<Course>();

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
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
