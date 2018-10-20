package com.capgemini.ems.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grade_master")
public class EmployeeGradeBean {

	@Id
	@Column(name = "grade_code")
	private String gradeCode;
	
	private String description;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	public EmployeeGradeBean() {
	}

	//Parameterized constructor for EmployeeGrade
	public EmployeeGradeBean(String gradeCode, String description, int minSalary,
			int maxSalary) {
		this.gradeCode = gradeCode;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}


	
	//Getters and Setters for EmployeeGrade properties
	public String getGradeCode() {
		return gradeCode;
	}


	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getMinSalary() {
		return minSalary;
	}


	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}


	public int getMaxSalary() {
		return maxSalary;
	}


	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	//toString method for EmployeeGrade
	@Override
	public String toString() {
		return "EmployeeGrade [gradeCode=" + gradeCode + ", description="
				+ description + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}

}
