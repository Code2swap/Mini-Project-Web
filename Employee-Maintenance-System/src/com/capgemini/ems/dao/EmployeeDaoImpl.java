package com.capgemini.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeLeaveBean;
import com.capgemini.ems.exception.EMSException;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@PersistenceContext
	EntityManager eManager;
	
	@Override
	public List<EmployeeBean> searchById(String empId, char wildcardChar)
			throws EMSException {
		
		String qryStr = "SELECT employee FROM EmployeeBean employee WHERE employee.id LIKE :searchStr";
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr, EmployeeBean.class);
		String searchStr = empId;
		if(wildcardChar == '*') {
			searchStr += "%";
		} else {
			searchStr += "_";
		}
		query.setParameter("searchStr", searchStr);
		List<EmployeeBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public List<EmployeeBean> searchByFirstName(String empFName,
			char wildcardChar) throws EMSException {
		String qryStr = "SELECT employee FROM EmployeeBean employee WHERE employee.firstName LIKE :searchStr";
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr, EmployeeBean.class);
		String searchStr = empFName;
		if(wildcardChar == '*') {
			searchStr += "%";
		} else {
			searchStr += "_";
		}
		query.setParameter("searchStr", searchStr);
		List<EmployeeBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public List<EmployeeBean> searchByLastName(String empLName,
			char wildcardChar) throws EMSException {
		String qryStr = "SELECT employee FROM EmployeeBean employee WHERE employee.lastName LIKE :searchStr";
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr, EmployeeBean.class);
		String searchStr = empLName;
		if(wildcardChar == '*') {
			searchStr += "%";
		} else {
			searchStr += "_";
		}
		query.setParameter("searchStr", searchStr);
		List<EmployeeBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public List<EmployeeBean> searchByDept(List<String> empDeptNames)
			throws EMSException {
		String qryStr = "SELECT employee FROM EmployeeBean employee WHERE employee.deptId"
				+ " IN (SELECT DISTINCT dept.deptId FROM DepartmentBean dept WHERE"
				+ " dept.deptName IN :deptNames)";
		
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr, EmployeeBean.class);
		query.setParameter("deptNames", empDeptNames);
		List<EmployeeBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public List<EmployeeBean> searchByGrade(List<String> empGrades)
			throws EMSException {
		String qryStr = "SELECT employee FROM EmployeeBean employee WHERE employee.grade IN :grades";
		
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr, EmployeeBean.class);
		query.setParameter("grades", empGrades);
		List<EmployeeBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public EmployeeBean getEmployeeById(String empId) throws EMSException {
		return null;
	}

	@Override
	public List<EmployeeBean> searchByMarital(List<String> empMarital)
			throws EMSException {
		String qryStr = "SELECT employee FROM EmployeeBean employee WHERE employee.marital IN :maritals";
		
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr, EmployeeBean.class);
		query.setParameter("maritals", empMarital);
		List<EmployeeBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public boolean applyLeave(EmployeeLeaveBean employeeLeave)
			throws EMSException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectLeave(int leaveId) throws EMSException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeLeaveBean> getAllAppliedLeaves(String mgrId)
			throws EMSException {
		String qryStr = "SELECT employeeLeave FROM EmployeeLeaveBean employeeLeave WHERE employeeLeave.empId"
				+ " IN (SELECT DISTINCT employee.id FROM EmployeeBean employee WHERE"
				+ " employee.mgrId =:mgrId)";
		TypedQuery<EmployeeLeaveBean> query = eManager.createQuery(qryStr, EmployeeLeaveBean.class);
		query.setParameter("mgrId",mgrId);
		List<EmployeeLeaveBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public boolean approveLeave(int leaveId) throws EMSException {
		// TODO Auto-generated method stub
		return false;
	}

}
