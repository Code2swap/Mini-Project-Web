package com.capgemini.ems.service;

import com.capgemini.ems.bean.UserBean;
import com.capgemini.ems.exception.EMSException;

public interface IAuthenticationService {

	UserBean getUser(String userName, String userPassword) throws EMSException;

	String getDesignation(String empId) throws EMSException;

}
