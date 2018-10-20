package com.capgemini.ems.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_master")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id")
	private String empId;
	
	@NotEmpty(message = "Field is Mandatory")
	@Column(name = "user_name", unique = true)
	private String userName; // unique
	
	@NotEmpty(message = "Field is Mandatory")
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_type")
	private String userType; // ADMIN or EMPLOYEE
		
	public UserBean() {		
	}
	
	//Parameterized constructor for User
	public UserBean(String empId, String userName, String userPassword, String userType) {
		this.empId = empId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
	}
	
	//Getters and Setters for  User properties
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	//toString method for Department
	@Override
	public String toString() {
		return "UserBean [empId=" + empId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userType=" + userType
				+ "]";
	}
	
}
