package com.student.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_STUDENT")
public class Student extends Person{
	
	public Student() {
		super();
	}

	public Student(String name) {
		super(name);
	}

	public Student(int id, String name) {
		super(id, name);
	}

	@OneToMany
	@JoinColumn(name="STUDENT_ID")
	private List<Enrollment> enrollments= new ArrayList<Enrollment>();
	
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	@Override
	public String toString() {
		return "Student [id=" + getId() + ", name=" + getName() + "]";
	}

}
