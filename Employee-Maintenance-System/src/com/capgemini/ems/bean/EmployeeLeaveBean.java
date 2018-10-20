package com.capgemini.ems.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "leave_history")
public class EmployeeLeaveBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "leave_id")
	@SequenceGenerator(name = "leaveSeq", sequenceName = "LEAVE_SEQ", allocationSize = 1, initialValue = 10001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leaveSeq")
	private int leaveId;
	
	@Column(name = "emp_id")
	private String empId;
	
	@Column(name = "applied_date")
	private Date appliedDate;
	
	@Column(name = "noofdays_applied")
	private int leaveDuration;
	
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "to_date")
	private Date toDate;
	
	private String status; // drop down with values("Applied", "Approved", "Rejected")

	public EmployeeLeaveBean() {
	}
	
	//Parameterized constructor for EmployeeLeave
	public EmployeeLeaveBean(int leaveId, String empId, Date appliedDate, int leaveDuration, Date fromDate, Date toDate,
			String status) {
		this.leaveId = leaveId;
		this.empId = empId;
		this.appliedDate = appliedDate;
		this.leaveDuration = leaveDuration;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
	}
	
	//toString method for EmployeeLeave
	@Override
	public String toString() {
		return "EmployeeLeave [leaveId=" + leaveId + ", empId=" + empId + ", appliedDate=" + appliedDate
				+ ", leaveDuration=" + leaveDuration + ", fromDate=" + fromDate + ", toDate=" + toDate + ", status="
				+ status + "]";
	}

	
	//Getters and Setters for EmployeeLeave properties
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public int getLeaveDuration() {
		return leaveDuration;
	}

	public void setLeaveDuration(int leaveDuration) {
		this.leaveDuration = leaveDuration;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
