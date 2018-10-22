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
	private String id;
	
	@Column(name = "emp_first_name")
	private String firstName;
	
	@Column(name = "emp_last_name")
	private String lastName;
	
	@Column(name = "emp_date_of_birth")
	private Date DOB;
	
	@Column(name = "emp_date_of_joining")
	private Date DOJ;
	
	@Column(name = "emp_dept_id")
	private int deptId;
	
	@Column(name = "emp_grade")
	private String grade;
	
	@Column(name = "emp_designation")
	private String designation;
	
	@Column(name = "emp_basic")
	private int basic;
	
	@Column(name = "emp_gender")
	private char gender;
	
	@Column(name = "emp_marital_status")
	private String marital;
	
	@Column(name = "emp_home_address")
	private String address;
	
	@Column(name = "emp_contact_num")
	private String contact;
	
	@Column(name = "mgr_id")
	private String mgrId;
	
	@Column(name = "emp_leave_bal")
	private int leaveBal;
	
	public EmployeeBean() {	
	}

	public EmployeeBean(String id, String firstName, String lastName, Date dOB,
			Date dOJ, int deptId, String grade, String designation, int basic,
			char gender, String marital, String address, String contact,
			String mgrId, int leaveBal) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		DOJ = dOJ;
		this.deptId = deptId;
		this.grade = grade;
		this.designation = designation;
		this.basic = basic;
		this.gender = gender;
		this.marital = marital;
		this.address = address;
		this.contact = contact;
		this.mgrId = mgrId;
		this.leaveBal = leaveBal;
	}

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", DOB=" + DOB + ", DOJ=" + DOJ
				+ ", deptId=" + deptId + ", grade=" + grade + ", designation="
				+ designation + ", basic=" + basic + ", gender=" + gender
				+ ", marital=" + marital + ", address=" + address
				+ ", contact=" + contact + ", mgrId=" + mgrId + ", leaveBal="
				+ leaveBal + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public int getLeaveBal() {
		return leaveBal;
	}

	public void setLeaveBal(int leaveBal) {
		this.leaveBal = leaveBal;
	}
	
}