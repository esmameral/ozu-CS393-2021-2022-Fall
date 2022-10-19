package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_ASSESSMENT")
public class Assessment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private AssessmentType type;
	
	private int weight;
	
	@ManyToOne
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
