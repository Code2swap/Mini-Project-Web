package com.capgemini.ems.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.ems.bean.UserBean;
import com.capgemini.ems.exception.EMSException;
import com.capgemini.ems.service.IAuthenticationService;

@Controller
public class LoginController {

	@Autowired
	private IAuthenticationService authenticationService;

	@RequestMapping(value = "/displayLogin")
	public String displayLogin(Model model) {
		System.out.println("Displaying Login Page");
		model.addAttribute("userDetails", new UserBean());
		return "Login";
	}
	
	@RequestMapping(value = "/userHome")
	public String displayUserHome(@RequestParam("name") String userName, 
			@RequestParam("pass") String userPassword, Model model) {
		System.out.println("Diplaying Home Page for Admin/Employee");

		String home = "LoginAgain";
		try {
			UserBean user = authenticationService.getUser(userName, userPassword);
			System.out.println(user);
			model.addAttribute("userDetails", user);
			if(user.getUserType().equals("ADMIN")) {
				home = "AdminHome";
			} else {
				String designation = authenticationService.getDesignation(user.getEmpId());
				System.out.println(designation);
				if(designation.equals("Manager")) {
					home = "ManagerHome";
				}
				else {
					home = "EmployeeHome";
				}
			}
		} catch (EMSException e) {
			// use logger
			System.out.println(e.getMessage());
		}
		
		return home;
	}

	// internal exceptional handler
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("errorObj", exception);
		mav.setViewName("Error");
		return mav;
	}
}
