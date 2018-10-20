package com.capgemini.ems.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "emp_id")
	private String empId;
	
	@Column(name = "emp_first_name")
	private String empFirstName;
	
	@Column(name = "emp_last_name")
	private String empLastName;
	
	@Column(name = "emp_date_of_birth")
	private Date empDOB;
	
	@Column(name = "emp_date_of_joining")
	private Date empDOJ;
	
	@Column(name = "emp_date_id")
	private int empDeptId;
	
	@Column(name = "emp_grade")
	private String empGrade;
	
	@Column(name = "emp_designation")
	private String empDesignation;
	
	@Column(name = "emp_basic")
	private int empBasic;
	
	@Column(name = "emp_gender")
	private char empGender;
	
	@Column(name = "emp_marital_status")
	private String empMarital;
	
	@Column(name = "emp_home_address")
	private String empAddress;
	
	@Column(name = "emp_contact_num")
	private String empContact;
	
	@Column(name = "mgr_id")
	private String mgrId;
	
	@Column(name = "emp_leave_bal")
	private int empLeaveBal;
	
	public EmployeeBean() {	
	}
	
	
	//Parameterized constructor for Employee
	public EmployeeBean(String empId, String empFirstName, String empLastName,
			Date empDOB, Date empDOJ, int empDeptId, String empGrade,
			String empDesignation, int empBasic, char empGender,
			String empMarital, String empAddress, String empContact,
			String mgrId, int empLeaveBal) {
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empDOB = empDOB;
		this.empDOJ = empDOJ;
		this.empDeptId = empDeptId;
		this.empGrade = empGrade;
		this.empDesignation = empDesignation;
		this.empBasic = empBasic;
		this.empGender = empGender;
		this.empMarital = empMarital;
		this.empAddress = empAddress;
		this.empContact = empContact;
		this.mgrId = mgrId;
		this.empLeaveBal = empLeaveBal;
	}

	
	
	//Getters and Setters for Employee properties
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	public Date getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}

	public int getEmpDeptId() {
		return empDeptId;
	}

	public void setEmpDeptId(int empDeptId) {
		this.empDeptId = empDeptId;
	}

	public String getEmpGrade() {
		return empGrade;
	}

	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public int getEmpBasic() {
		return empBasic;
	}

	public void setEmpBasic(int empBasic) {
		this.empBasic = empBasic;
	}

	public char getEmpGender() {
		return empGender;
	}

	public void setEmpGender(char empGender) {
		this.empGender = empGender;
	}

	public String getEmpMarital() {
		return empMarital;
	}

	public void setEmpMarital(String empMarital) {
		this.empMarital = empMarital;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public int getEmpLeaveBal() {
		return empLeaveBal;
	}

	public void setEmpLeaveBal(int empLeaveBal) {
		this.empLeaveBal = empLeaveBal;
	}

	
	//toString method for Employee
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName
				+ ", empLastName=" + empLastName + ", empDOB=" + empDOB + ", empDOJ="
				+ empDOJ + ", empDeptId=" + empDeptId + ", empGrade="
				+ empGrade + ", empDesignation=" + empDesignation
				+ ", empBasic=" + empBasic + ", empGender=" + empGender
				+ ", empMarital=" + empMarital + ", empAddress=" + empAddress
				+ ", empContact=" + empContact + ", mgrId=" + mgrId
				+ ", empLeaveBal=" + empLeaveBal + "]";
	}


}
