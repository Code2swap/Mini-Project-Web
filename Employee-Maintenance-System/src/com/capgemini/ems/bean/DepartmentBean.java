package com.capgemini.ems.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentBean {

	@Id
	@Column(name = "dept_id")
	private int deptId;
	
	@Column(name = "dept_name")
	private String deptName;
	
	public DepartmentBean() {
	}
	
	//Parameterized constructor for Department
	public DepartmentBean(String deptName, int deptId) {
		this.deptName = deptName;
		this.deptId = deptId;
	}
	//Getters and Setters for  Department properties
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	//toString method for Department
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptId=" + deptId + "]";
	}
	
}
