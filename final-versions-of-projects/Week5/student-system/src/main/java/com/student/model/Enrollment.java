package com.student.model;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {
	private int id;
	private double grade;
	private String letterGrade;
	
	private List<Score> scores=new ArrayList<>();
	private Course course;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getLetterGrade() {
		return letterGrade;
	}
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
