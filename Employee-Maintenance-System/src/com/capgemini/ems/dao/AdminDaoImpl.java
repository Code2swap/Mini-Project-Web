package com.capgemini.ems.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.ems.bean.DepartmentBean;
import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeGradeBean;
import com.capgemini.ems.exception.EMSException;

@Transactional
@Repository
public class AdminDaoImpl implements IAdminDao {

	@PersistenceContext
	private EntityManager eManager;

	@Override
	public boolean addEmployee(EmployeeBean employee) throws EMSException {
		boolean success = false;
		try {
			eManager.persist(employee);
			success = true;
		} catch (Exception e) {
			throw new EMSException(e.getMessage());
		}

		return success;
	}

	@Override
	public List<DepartmentBean> getDepartmentList() throws EMSException {
		String qStr = "SELECT dept FROM DepartmentBean dept";
		TypedQuery<DepartmentBean> query = eManager.createQuery(qStr, DepartmentBean.class);
		List<DepartmentBean> deptList = query.getResultList();
		return deptList;
	}

	@Override
	public List<EmployeeGradeBean> getGradeList() throws EMSException {
		String qStr = "SELECT grade FROM EmployeeGradeBean grade";
		TypedQuery<EmployeeGradeBean> query = eManager.createQuery(qStr, EmployeeGradeBean.class);
		List<EmployeeGradeBean> gradeList = query.getResultList();
		return gradeList;
	}

	@Override
	public List<String> getMaritalStatusList() throws EMSException {

		List<String> statusList = new ArrayList<String>();
		statusList.add("Single");
		statusList.add("Married");
		statusList.add("Divorced");
		statusList.add("Separated");
		statusList.add("Widowed");
		return statusList;
	}

	@Override
	public List<EmployeeBean> getEmployeeDetails() throws EMSException {
		String sql = "SELECT employee from EmployeeBean employee";
		TypedQuery<EmployeeBean> qry = eManager.createQuery(sql, EmployeeBean.class);
		List<EmployeeBean> employeeList = qry.getResultList();
		return employeeList;
	}

	@Override
	public EmployeeBean findItem(String employeeId) throws EMSException {
		EmployeeBean employee = null;
		try {
			employee = eManager.find(EmployeeBean.class, employeeId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return employee;
	}

	@Override
	public boolean modifyEmployee(EmployeeBean employee) throws EMSException {
		boolean success = false;
		try {
			eManager.merge(employee);
			success = true;
		} catch (Exception e) {
			throw new EMSException(e.getMessage());
		}
		return success;
	}

}
