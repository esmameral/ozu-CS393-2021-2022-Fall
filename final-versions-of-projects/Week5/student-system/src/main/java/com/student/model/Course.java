package com.student.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private int id; 
	private String name;
	private String code;
	private String faculty;
	private List<Student> students=new ArrayList<Student>();
	private List<WeeklySubject> weeks=new ArrayList<WeeklySubject>();
	private List<Assessment> assessments=new ArrayList<Assessment>();
	
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

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<WeeklySubject> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<WeeklySubject> weeks) {
		this.weeks = weeks;
	}

	public List<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<Assessment> assessments) {
		this.assessments = assessments;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



}
