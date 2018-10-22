package com.capgemini.ems.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeLeaveBean;
import com.capgemini.ems.bean.UserBean;
import com.capgemini.ems.exception.EMSException;
import com.capgemini.ems.service.IEmployeeService;


@Controller
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
	@RequestMapping(value = "/searchById")
	public String searchById(){
		
		System.out.println("Going to search by Id");
		return "SearchById";
		
	}
	
	@RequestMapping(value = "/searchByFirstName")
	public String searchByFirstName(){
		
		System.out.println("Going to search by First Name");
		return "SearchByFirstName";
		
	}
	
	@RequestMapping(value = "/searchByLastName")
	public String searchByLastName(){
		
		System.out.println("Going to search by Last Name");
		return "SearchByLastName";
		
	}
	
	@RequestMapping(value = "/searchByDepartment")
	public String searchByDepartment(){
		
		System.out.println("Going to search by Department");
		return "SearchByDepartment";
		
	}
	
	@RequestMapping(value = "/searchByGrade")
	public String searchByGrade(){
		
		System.out.println("Going to search by Grade");
		return "SearchByGrade";
		
	}
	
	@RequestMapping(value = "/searchByMaritalStatus")
	public String searchByMaritalStatus(){
		
		System.out.println("Going to search by Marital Status");
		return "SearchByMaritalStatus";
		
	}
	
	@RequestMapping(value = "/applyLeave")
	public String applyLeave(@RequestParam("empId") String empId, Model model){
		
		System.out.println("Going to apply for Leave");
		System.out.println(empId);
		EmployeeLeaveBean employeeLeave = new EmployeeLeaveBean();
		employeeLeave.setEmpId(empId);
		model.addAttribute("employeeLeave", employeeLeave);
		return "ApplyLeave";
		
	}
	@RequestMapping(value = "/leaveApplied")
	public String leaveApplied(@Valid @ModelAttribute("employeeLeave") 
					EmployeeLeaveBean employeeLeave, Model model) {
		boolean success = false;
		try {
			success = employeeService.applyLeave(employeeLeave);
		} catch (EMSException e) {
			//logger
			System.out.println(e.getMessage());
		}
		if(success) {
			System.out.println("Leave successfully applied");
			return "LeaveAppliedSuccess";
		} else {
			System.out.println("Leave cannot be applied");
			return "LeaveAppliedFailure";
		}
	}
	@RequestMapping(value = "/searchResultsById")
	public String searchResultsById(@RequestParam Map<String, String> requestParam,  Model model){
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
	public String searchResultsByFirstName(@RequestParam Map<String, String> requestParam, Model model){
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
	public String searchResultsByLastName(@RequestParam Map<String, String> requestParam, Model model){
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
	
	@RequestMapping(value = "/searchResultsByDepartment")
	public String searchResultsByDepartment(@RequestParam Map<String, String> requestParam){
		
		return "SearchResults";
	}
	
	@RequestMapping(value = "/searchResultsByGrade")
	public String searchResultsByGrade(@RequestParam Map<String, String> requestParam){
		
		return "SearchResults";
	}
	
	@RequestMapping(value = "/searchResultsByMaritalStatus")
	public String searchResultsByMaritalStatus(@RequestParam Map<String, String> requestParam){
		
		return "SearchResults";
	}
}
