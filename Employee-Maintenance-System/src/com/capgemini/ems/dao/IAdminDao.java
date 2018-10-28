package com.capgemini.ems.dao;

import java.util.List;

import com.capgemini.ems.bean.DepartmentBean;
import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeGradeBean;
import com.capgemini.ems.exception.EMSException;

public interface IAdminDao {

	boolean addEmployee(EmployeeBean employee) throws EMSException ;

	List<DepartmentBean> getDepartmentList() throws EMSException ;

	List<EmployeeGradeBean> getGradeList() throws EMSException ;

	List<String> getMaritalStatusList() throws EMSException ;

	List<EmployeeBean> getEmployeeDetails() throws EMSException ;

	EmployeeBean findItem(String employeeId) throws EMSException ;

	boolean modifyEmployee(EmployeeBean employee) throws EMSException;

}
