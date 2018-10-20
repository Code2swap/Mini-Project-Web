package com.capgemini.ems.service;

import com.capgemini.ems.bean.UserBean;

public interface IAuthenticationService {

	UserBean getUser(String userName, String userPassword);

}
