package com.student.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Transient
	private List<Enrollment> enrollments= new ArrayList<Enrollment>();
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name.toUpperCase();
	}
	
	public Student(String name) {
		super();
		this.name = name.toUpperCase();
	}



	public Student() {
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



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
