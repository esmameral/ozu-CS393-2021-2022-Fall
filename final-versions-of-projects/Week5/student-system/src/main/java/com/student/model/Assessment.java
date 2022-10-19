package com.student.model;

public class Assessment {
	
	private AssessmentType type;
	private int weight;
	private Course course;
	public AssessmentType getType() {
		return type;
	}
	public void setType(AssessmentType type) {
		this.type = type;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
