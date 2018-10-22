package com.capgemini.ems.dao;

import com.capgemini.ems.bean.UserBean;
import com.capgemini.ems.exception.EMSException;

public interface IAuthenticationDao {

	UserBean getUser(String userName, String userPassword) throws EMSException;

}
