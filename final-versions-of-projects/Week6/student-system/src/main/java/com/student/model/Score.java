package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_SCORE")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double value;
	@OneToOne
	private Assessment assessment;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
