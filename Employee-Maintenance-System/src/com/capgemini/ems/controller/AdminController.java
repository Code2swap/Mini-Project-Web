package com.capgemini.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.ems.bean.EmployeeBean;
import com.capgemini.ems.service.IAdminService;

@Controller
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@RequestMapping(value = "/getId")
	public String getId(Model model) {
		System.out.println("getId function");
		model.addAttribute("employeeId", new EmployeeBean());
		return "EnterId";
	}

	@RequestMapping("/findEmployee")
	public String findEmployee(
			@ModelAttribute("employeeId") EmployeeBean employee, Model model) {

		EmployeeBean item = adminService.findItem(employee.getId());

		List<Integer> deptList = adminService.getDepartmentList();
		model.addAttribute("departmentList", deptList);

		List<String> gradeList = adminService.getGradeList();
		model.addAttribute("gradeList", gradeList);

		List<String> maritalStatusList = adminService.getMaritalStatusList();
		model.addAttribute("maritalStatusList", maritalStatusList);

		model.addAttribute("employee", item);
		return "UpdateEmployee";
	}

	@RequestMapping(value = "/updateEmployee")
	public String modifyEmployee(
			@ModelAttribute("employee") @Valid EmployeeBean employee,
			BindingResult bindingResult, Model model) {
		boolean status = false;
		System.out.println("into submit");

		boolean hasError = bindingResult.hasErrors();
		// System.out.println("has error:"+hasError);

		if (hasError) {

			List<Integer> deptList = adminService.getDepartmentList();
			model.addAttribute("departmentList", deptList);

			List<String> gradeList = adminService.getGradeList();
			model.addAttribute("gradeList", gradeList);

			List<String> maritalStatusList = adminService.getMaritalStatusList();
			model.addAttribute("maritalStatusList", maritalStatusList);

			model.addAttribute("employee",employee);
			return "UpdateEmployee";
		} else {
			try {
				status = adminService.modifyEmployee(employee);
			} catch (Exception e) {

			}

			return "UpdateSuccess";
		}

	}

	@RequestMapping(value = "/addEmployee")
	public String addEmployeeForm(Model model) {

		List<Integer> deptList = adminService.getDepartmentList();
		model.addAttribute("departmentList", deptList);

		List<String> gradeList = adminService.getGradeList();
		model.addAttribute("gradeList", gradeList);

		List<String> maritalStatusList = adminService.getMaritalStatusList();
		model.addAttribute("maritalStatusList", maritalStatusList);

		model.addAttribute("addEmployee", new EmployeeBean());
		return "AddEmployee";
	}

	@RequestMapping(value = "/submitEmployee")
	public String submitEmployee(
			@ModelAttribute("addEmployee")@Valid EmployeeBean employee,BindingResult bindingResult,Model model) {
		System.out.println("into submit");
		boolean hasError = bindingResult.hasErrors();
		System.out.println("has error:"+hasError);

		
		adminService.addEmployee(employee);
		return "Success";
	}

	@RequestMapping("/getEmployeeList")
	public String getEmployeeList(Model model) {
		// System.out.println("into controller");
		List<EmployeeBean> employeeList = adminService.getEmployeeDetails();
		model.addAttribute("employeeList", employeeList);

		return "DisplayEmployee";
	}

}
