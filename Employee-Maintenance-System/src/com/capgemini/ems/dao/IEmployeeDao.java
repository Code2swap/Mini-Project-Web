package com.capgemini.ems.dao;

import java.util.List;

import com.capgemini.ems.bean.DepartmentBean;
import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeLeaveBean;
import com.capgemini.ems.exception.EMSException;

public interface IEmployeeDao {

	boolean applyLeave(EmployeeLeaveBean employeeLeave) throws EMSException;
	
	boolean rejectLeave(int leaveId) throws EMSException;
	
	List<EmployeeLeaveBean> getAllAppliedLeaves(String mgrId) throws EMSException;
	
	boolean approveLeave(int leaveId) throws EMSException;
	
	List<EmployeeBean> searchById(String empId, char wildcardChar) throws EMSException;
	
	List<EmployeeBean> searchByFirstName(String empFName, char wildcardChar) throws EMSException;
	
	List<EmployeeBean> searchByLastName(String empLName, char wildcardChar) throws EMSException;
	
	List<EmployeeBean> searchByDept(List<String> empDeptNames) throws EMSException;
	
	List<EmployeeBean> searchByGrade(List<String> empGrades) throws EMSException;
		
	EmployeeBean getEmployeeById(String empId) throws EMSException;

	List<EmployeeBean> searchByMarital(List<String> empMarital) throws EMSException;

	List<String> getAllDepartments() throws EMSException ;
	
	List<String> getAllGrades();
	
	List<String> getAllMaritals();
}
