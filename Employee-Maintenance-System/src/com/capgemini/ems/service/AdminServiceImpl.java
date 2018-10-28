package com.capgemini.ems.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ems.bean.DepartmentBean;
import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeGradeBean;
import com.capgemini.ems.dao.IAdminDao;
import com.capgemini.ems.exception.EMSException;

@Transactional
@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	public boolean addEmployee(EmployeeBean employee) throws EMSException {
		
		return adminDao.addEmployee(employee);
	}

	@Override
	public List<DepartmentBean> getDepartmentList() throws EMSException {
		
		return adminDao.getDepartmentList();
	}

	@Override
	public List<EmployeeGradeBean> getGradeList() throws EMSException {
		
		return adminDao.getGradeList();
	}

	@Override
	public List<String> getMaritalStatusList() throws EMSException {
		
		return adminDao.getMaritalStatusList();
	}

	@Override
	public List<EmployeeBean> getEmployeeDetails() throws EMSException {
		
		return adminDao.getEmployeeDetails();
	}

	@Override
	public EmployeeBean findItem(String employeeId) throws EMSException {
		
		return adminDao.findItem(employeeId);
	}

	@Override
	public boolean modifyEmployee(EmployeeBean employee) throws EMSException {
		
		return adminDao.modifyEmployee(employee);
	}

}
