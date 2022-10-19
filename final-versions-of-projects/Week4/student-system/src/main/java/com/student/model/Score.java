package com.student.model;

public class Score {
	private String id;
	private double value;
	private Assessment assessment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	
}
