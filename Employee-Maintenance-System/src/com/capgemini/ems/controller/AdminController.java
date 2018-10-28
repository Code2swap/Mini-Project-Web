package com.capgemini.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.ems.bean.DepartmentBean;
import com.capgemini.ems.bean.DepartmentListBean;
import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.bean.EmployeeGradeBean;
import com.capgemini.ems.exception.EMSException;
import com.capgemini.ems.service.IAdminService;
import com.capgemini.ems.service.IEmployeeService;

@Controller
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = "/getId")
	public String getId(Model model) {
		System.out.println("Getting employee id...");
		model.addAttribute("employee", new EmployeeBean());
		return "EnterId";
	}

	@RequestMapping("/findEmployee")
	public String findEmployee(@ModelAttribute("employee") EmployeeBean employee, Model model) {

		EmployeeBean currentEmployee;
		try {
			currentEmployee = adminService.findItem(employee.getId());
			
			List<DepartmentBean> deptList = adminService.getDepartmentList();
			model.addAttribute("departmentList", deptList);

			List<String> gradeList = employeeService.getAllGrades();
			model.addAttribute("gradeList", gradeList);

			List<String> maritalStatusList = adminService.getMaritalStatusList();
			model.addAttribute("maritalList", maritalStatusList);

			model.addAttribute("employee", currentEmployee);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}

		
		return "UpdateEmployee";
	}

	@RequestMapping(value = "/updateEmployee")
	public String modifyEmployee(@ModelAttribute("employee") @Valid EmployeeBean employee, BindingResult bindingResult,
			Model model) {
		boolean status = false;
		System.out.println("Updating employee...");

		boolean hasError = bindingResult.hasErrors();
		// System.out.println("has error:"+hasError);

		try {
			if (hasError) {
				List<DepartmentBean> deptList = adminService.getDepartmentList();
				model.addAttribute("departmentList", deptList);

				List<String> gradeList = employeeService.getAllGrades();
				model.addAttribute("gradeList", gradeList);

				List<String> maritalStatusList = employeeService.getAllMaritals();
				model.addAttribute("maritalStatusList", maritalStatusList);

				model.addAttribute("employee", employee);
				return "UpdateEmployee";
			}
			status = adminService.modifyEmployee(employee);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		return "UpdateSuccess";
	}

	@RequestMapping(value = "/addEmployee")
	public String addEmployeeForm(Model model) {

		try {
			List<DepartmentBean> deptList = adminService.getDepartmentList();
			System.out.println(deptList);
			model.addAttribute("departmentList", deptList);

			List<String> gradeList = employeeService.getAllGrades();
			System.out.println(gradeList);
			model.addAttribute("gradeList", gradeList);

			List<String> maritalStatusList = employeeService.getAllMaritals();
			System.err.println(maritalStatusList);
			model.addAttribute("maritalList", maritalStatusList);

			model.addAttribute("employee", new EmployeeBean());
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}

		return "AddEmployee";
	}

	@RequestMapping(value = "/submitEmployee")
	public String submitEmployee(@Valid @ModelAttribute("addEmployee") EmployeeBean employee,
			BindingResult bindingResult, Model model) {
		System.out.println("Adding employee...");
		boolean hasError = bindingResult.hasErrors();
		System.out.println("has error:" + hasError);
		if(hasError) {
			return "AddEmployee";
		}
		try {
			System.out.println(employee);
			adminService.addEmployee(employee);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}
		return "Success";
	}

	@RequestMapping("/getEmployeeList")
	public String getEmployeeList(Model model) {
		System.out.println("Fetching all employees...");
		List<EmployeeBean> employeeList;
		try {
			employeeList = adminService.getEmployeeDetails();
			model.addAttribute("employeeList", employeeList);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		}

		return "DisplayEmployee";
	}

}
