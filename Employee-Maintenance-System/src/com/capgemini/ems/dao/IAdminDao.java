package com.capgemini.ems.dao;

import java.util.List;

import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.exception.EMSException;

public interface IAdminDao {

	boolean addEmployee(EmployeeBean employee);

	List<Integer> getDepartmentList();

	List<String> getGradeList();

	List<String> getMaritalStatusList();

	List<EmployeeBean> getEmployeeDetails();

	EmployeeBean findItem(String employeeId);

	boolean modifyEmployee(EmployeeBean employee) throws EMSException;

}
