package com.student.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_INSTRUCTOR")
public class Instructor extends Person{

	
	
	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
	private List<Course> courses=new ArrayList<>();


	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


}
