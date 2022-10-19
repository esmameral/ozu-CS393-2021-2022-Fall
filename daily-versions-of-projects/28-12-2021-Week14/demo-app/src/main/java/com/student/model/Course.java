package com.student.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_COURSE")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String code;
	private String faculty;
	@Column(nullable = true)
	private int credit;
	@Column(name = "COURSE_TYPE",length = 1)
	private String courseType;
	
	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	@ManyToOne
	@JsonIgnore
	private Instructor instructor;
	
	
	@OneToMany(mappedBy = "course")
	private List<WeeklySubject> weeks=new ArrayList<WeeklySubject>();
	
	@OneToMany(mappedBy = "course")
	private List<Assessment> assessments=new ArrayList<Assessment>();
	
	@OneToMany(mappedBy = "course")
	private List<Enrollment> enrollments=new ArrayList<Enrollment>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
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

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}



}
