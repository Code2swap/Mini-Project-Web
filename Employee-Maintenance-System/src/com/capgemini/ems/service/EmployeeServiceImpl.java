package com.capgemini.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ems.bean.DepartmentBean;
import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeLeaveBean;
import com.capgemini.ems.dao.IEmployeeDao;
import com.capgemini.ems.exception.EMSException;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDao employeeDao;
	
	@Override
	public List<EmployeeBean> searchById(String empId, char wildcardChar)
			throws EMSException {
		return employeeDao.searchById(empId, wildcardChar);
	}

	@Override
	public List<EmployeeBean> searchByFirstName(String empFName,
			char wildcardChar) throws EMSException {
		return employeeDao.searchByFirstName(empFName, wildcardChar);
	}

	@Override
	public List<EmployeeBean> searchByLastName(String empLName,
			char wildcardChar) throws EMSException {
		return employeeDao.searchByLastName(empLName, wildcardChar);
	}

	@Override
	public List<EmployeeBean> searchByDept(List<String> empDeptNames)
			throws EMSException {
		return employeeDao.searchByDept(empDeptNames);
	}

	@Override
	public List<EmployeeBean> searchByGrade(List<String> empGrades)
			throws EMSException {
		return employeeDao.searchByGrade(empGrades);
	}

	@Override
	public EmployeeBean getEmployeeById(String empId) throws EMSException {
		return employeeDao.getEmployeeById(empId);
	}

	@Override
	public List<EmployeeBean> searchByMarital(List<String> empMarital)
			throws EMSException {
		return employeeDao.searchByMarital(empMarital);
	}

	@Override
	public boolean applyLeave(EmployeeLeaveBean employeeLeave)
			throws EMSException {
		return employeeDao.applyLeave(employeeLeave);
	}

	@Override
	public boolean rejectLeave(int leaveId) throws EMSException {
		return employeeDao.rejectLeave(leaveId);
	}

	@Override
	public List<EmployeeLeaveBean> getAllAppliedLeaves(String mgrId)
			throws EMSException {
		return employeeDao.getAllAppliedLeaves(mgrId);
	}

	@Override
	public boolean approveLeave(int leaveId) throws EMSException {
		return employeeDao.approveLeave(leaveId);
	}

	@Override
	public List<String> getAllDepartments() throws EMSException {
		return employeeDao.getAllDepartments();
	}

	@Override
	public List<String> getAllGrades() {
		return employeeDao.getAllGrades();
	}

	@Override
	public List<String> getAllMaritals() {
		return employeeDao.getAllMaritals();
	}

}
