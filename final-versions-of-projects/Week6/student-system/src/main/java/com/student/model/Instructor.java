package com.student.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_INSTRUCTOR")
public class Instructor  extends Person {


	
	@Column(name = "OFFICE_NUMBER")
	private String officeNumber;
	@Column(name = "OFFICE_HOURS")
	private String officeHours;
	
	@OneToMany(mappedBy = "instructor")
	private List<Course> courses=new ArrayList<>();
	
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public String getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
