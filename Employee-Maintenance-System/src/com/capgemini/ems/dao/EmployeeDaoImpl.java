package com.capgemini.ems.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import jdk.nashorn.internal.AssertsEnabled;

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
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr,
				EmployeeBean.class);
		String searchStr = empId;
		if (wildcardChar == '*') {
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
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr,
				EmployeeBean.class);
		String searchStr = empFName;
		if (wildcardChar == '*') {
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
		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr,
				EmployeeBean.class);
		String searchStr = empLName;
		if (wildcardChar == '*') {
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
				+ " dept.deptName IN (:deptNames))";

		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr,
				EmployeeBean.class);
		query.setParameter("deptNames", empDeptNames);
		List<EmployeeBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public List<EmployeeBean> searchByGrade(List<String> empGrades)
			throws EMSException {
		String qryStr = "SELECT employee FROM EmployeeBean employee WHERE employee.grade IN (:grades)";

		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr,
				EmployeeBean.class);
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
		String qryStr = "SELECT employee FROM EmployeeBean employee WHERE employee.marital IN (:maritals)";

		TypedQuery<EmployeeBean> query = eManager.createQuery(qryStr,
				EmployeeBean.class);
		query.setParameter("maritals", empMarital);
		List<EmployeeBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public boolean applyLeave(EmployeeLeaveBean employeeLeave)
			throws EMSException {
		boolean success = false;
		try {
			eManager.persist(employeeLeave);
			success = true;
		} catch (Exception e) {

			throw new EMSException(e.getMessage());
		}
		return success;
	}

	@Override
	public boolean rejectLeave(int leaveId) throws EMSException {
		boolean success = false;
		try {
			String qryStr = "UPDATE EmployeeLeaveBean employeeLeave SET employeeLeave.status = :rejected  WHERE employeeLeave.leaveId = :leaveId";
			Query query = eManager.createQuery(qryStr);
			query.setParameter("rejected", "Rejected");
			query.setParameter("leaveId", leaveId);
			int rowUpdated = query.executeUpdate();
			assert (rowUpdated <= 1);
			success = true;
		} catch (Exception e) {

			throw new EMSException(e.getMessage());
		}
		return success;
	}

	@Override
	public List<EmployeeLeaveBean> getAllAppliedLeaves(String mgrId)
			throws EMSException {
		String qryStr = "SELECT employeeLeave FROM EmployeeLeaveBean employeeLeave WHERE"
				+ " employeeLeave.status = :applied AND employeeLeave.empId"
				+ " IN (SELECT DISTINCT employee.id FROM EmployeeBean employee WHERE"
				+ " employee.mgrId =:mgrId)";
		TypedQuery<EmployeeLeaveBean> query = eManager.createQuery(qryStr,
				EmployeeLeaveBean.class);
		query.setParameter("applied", "Applied");
		query.setParameter("mgrId", mgrId);
		List<EmployeeLeaveBean> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public boolean approveLeave(int leaveId) throws EMSException {
		boolean success = false;
		try {
			// first check if there are sufficient leave balance then only approve
			// write code
			
			
			// then approve
			String qryStr = "UPDATE EmployeeLeaveBean employeeLeave SET employeeLeave.status = :approved  WHERE employeeLeave.leaveId = :leaveId";
			Query query = eManager.createQuery(qryStr);
			query.setParameter("approved", "Approved");
			query.setParameter("leaveId", leaveId);
			int rowUpdated = query.executeUpdate();
			assert (rowUpdated <= 1);
			success = true;
		} catch (Exception e) {
			throw new EMSException(e.getMessage());
		}
		return success;
	}

	@Override
	public List<String> getAllDepartments() throws EMSException {
		String qry = "SELECT dept.deptName FROM DepartmentBean dept";
		TypedQuery<String> query = eManager.createQuery(qry, String.class);
		List<String> deptList = query.getResultList();
		return deptList;
	}

	@Override
	public List<String> getAllGrades() {
		String[] grades = { "M1", "M2", "M3", "M4", "M5", "M6", "M7" };
		return Arrays.asList(grades);
	}

	@Override
	public List<String> getAllMaritals() {
		String[] maritals = { "Married", "Single", "Seperated", "Widowed",
				"Divorced" };
		return Arrays.asList(maritals);
	}

}
