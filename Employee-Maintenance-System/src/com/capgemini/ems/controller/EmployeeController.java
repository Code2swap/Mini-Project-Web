package com.capgemini.ems.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.ems.bean.DepartmentListBean;
import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeLeaveBean;
import com.capgemini.ems.bean.GradeListBean;
import com.capgemini.ems.bean.MaritalListBean;
import com.capgemini.ems.exception.EMSException;
import com.capgemini.ems.service.IEmployeeService;

@Controller
public class EmployeeController {
	static int leaveId = 10000;
	@Autowired
	IEmployeeService employeeService;

	@RequestMapping(value = "/searchById")
	public String searchById() {

		System.out.println("Going to search by Id");
		return "SearchById";

	}

	@RequestMapping(value = "/searchByFirstName")
	public String searchByFirstName() {

		System.out.println("Going to search by First Name");
		return "SearchByFirstName";

	}

	@RequestMapping(value = "/searchByLastName")
	public String searchByLastName() {

		System.out.println("Going to search by Last Name");
		return "SearchByLastName";

	}

	@RequestMapping(value = "/searchByDepartment")
	public String searchByDepartment(Model model) {
		System.out.println("Going to search by Department");
		try {
			List<String> departmentList = employeeService.getAllDepartments();
			System.out.println(departmentList);
			DepartmentListBean departmentListObject = new DepartmentListBean();
			departmentListObject.setDepartments(departmentList);
			model.addAttribute("departmentListObject", departmentListObject);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		return "SearchByDepartment";

	}

	@RequestMapping(value = "/searchByGrade")
	public String searchByGrade(Model model) {

		System.out.println("Going to search by Grade");
		List<String> gradeList = employeeService.getAllGrades();
		System.out.println(gradeList);
		GradeListBean gradeListObject = new GradeListBean();
		gradeListObject.setGrades(gradeList);
		model.addAttribute("gradeListObject", gradeListObject);

		return "SearchByGrade";

	}

	@RequestMapping(value = "/searchByMaritalStatus")
	public String searchByMaritalStatus(Model model) {

		System.out.println("Going to search by Marital Status");
		List<String> maritalList = employeeService.getAllMaritals();
		System.out.println(maritalList);
		MaritalListBean maritalListObject = new MaritalListBean();
		maritalListObject.setMaritals(maritalList);
		model.addAttribute("maritalListObject", maritalListObject);
		return "SearchByMaritalStatus";

	}
	@RequestMapping(value = "/manageLeave")
	public String manageLeave(@RequestParam("empId") String empId, Model model) {
		System.out.println("Going to manage Leave");
		System.out.println(empId);
		try {
			List<EmployeeLeaveBean> employeeLeaveList = employeeService.getAllAppliedLeaves(empId);
			model.addAttribute("employeeLeaveList", employeeLeaveList);
			
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		
		return "ManageLeave";
	}
	@RequestMapping(value = "/applyLeave")
	public String applyLeave(@RequestParam("empId") String empId, Model model) {

		System.out.println("Going to apply for Leave");
		System.out.println(empId);
		EmployeeLeaveBean employeeLeave = new EmployeeLeaveBean();
		employeeLeave.setEmpId(empId);
		model.addAttribute("employeeLeave", employeeLeave);
		return "ApplyLeave";

	}

	@RequestMapping(value = "/leaveApplied")
	public String leaveApplied(@Valid @ModelAttribute("employeeLeave") EmployeeLeaveBean employeeLeave, Model model) {
		boolean success = false;
		
		try {
			System.out.println(employeeLeave);
			Date today = Date.valueOf(LocalDate.now());
			if (employeeLeave.getFromDate().compareTo(today) <= 0) {
				//logger
				System.err.println("FROM DATE must be ahead of today");
			}
			if (employeeLeave.getToDate().compareTo(employeeLeave.getFromDate()) < 0) {
				//logger
				System.err.println("TO DATE must be ahead of FROM DATE");
				model.addAttribute("employeeLeave", employeeLeave);
				return "ApplyLeaveAgain";
			}
			
			employeeLeave.setLeaveId(leaveId++);
			employeeLeave.setAppliedDate(Date.valueOf(LocalDate.now()));
			employeeLeave.setStatus("Applied");
			int leaveDuration = 1 + (int) TimeUnit.MILLISECONDS
					.toDays(employeeLeave.getToDate().getTime() - employeeLeave.getFromDate().getTime());
			employeeLeave.setLeaveDuration(leaveDuration);
			
			success = employeeService.applyLeave(employeeLeave);
		} catch (EMSException e) {
			// logger
			System.out.println(e.getMessage());
		}
		if (success) {
			System.out.println("Leave successfully applied");
			return "LeaveAppliedSuccess";
		} else {
			System.out.println("Leave cannot be applied");
			return "LeaveAppliedFailure";
		}
	}

	@RequestMapping(value = "/searchResultsById")
	public String searchResultsById(@RequestParam Map<String, String> requestParam, Model model) {
		String searchId = requestParam.get("searchId");
		char wildCardChar = requestParam.get("wildCardChar").charAt(0);
		System.out.println(searchId + " " + wildCardChar);
		try {
			List<EmployeeBean> employees = employeeService.searchById(searchId, wildCardChar);
			System.out.println(employees);
			model.addAttribute("employeeList", employees);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		return "SearchResults";
	}

	@RequestMapping(value = "/searchResultsByFirstName")
	public String searchResultsByFirstName(@RequestParam Map<String, String> requestParam, Model model) {
		String firstName = requestParam.get("firstName");
		char wildCardChar = requestParam.get("wildCardChar").charAt(0);
		System.out.println(firstName + " " + wildCardChar);
		try {
			List<EmployeeBean> employees = employeeService.searchByFirstName(firstName, wildCardChar);
			System.out.println(employees);
			model.addAttribute("employeeList", employees);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		return "SearchResults";
	}

	@RequestMapping(value = "/searchResultsByLastName")
	public String searchResultsByLastName(@RequestParam Map<String, String> requestParam, Model model) {
		String lastName = requestParam.get("lastName");
		char wildCardChar = requestParam.get("wildCardChar").charAt(0);
		System.out.println(lastName + " " + wildCardChar);
		try {
			List<EmployeeBean> employees = employeeService.searchByLastName(lastName, wildCardChar);
			System.out.println(employees);
			model.addAttribute("employeeList", employees);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		return "SearchResults";
	}

	@RequestMapping(value = "/searchResultsByDepartment", method = RequestMethod.POST)
	public String searchResultsByDepartment(
			@ModelAttribute("departmentListObject") DepartmentListBean departmentListObject, Model model) {
		List<EmployeeBean> employeeList;
		try {
			employeeList = employeeService.searchByDept(departmentListObject.getDepartments());
			model.addAttribute("employeeList", employeeList);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}

		return "SearchResults";
	}

	@RequestMapping(value = "/searchResultsByGrade", method = RequestMethod.POST)
	public String searchResultsByGrade(@ModelAttribute("gradeListObject") GradeListBean gradeListObject, Model model) {
		List<EmployeeBean> employeeList;
		try {
			employeeList = employeeService.searchByGrade(gradeListObject.getGrades());
			model.addAttribute("employeeList", employeeList);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		return "SearchResults";
	}

	@RequestMapping(value = "/searchResultsByMarital", method = RequestMethod.POST)
	public String searchResultsByMaritalStatus(@ModelAttribute("maritalListObject") MaritalListBean maritalListObject,
			Model model) {
		List<EmployeeBean> employeeList;
		try {
			employeeList = employeeService.searchByMarital(maritalListObject.getMaritals());
			model.addAttribute("employeeList", employeeList);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		return "SearchResults";
	}
}
