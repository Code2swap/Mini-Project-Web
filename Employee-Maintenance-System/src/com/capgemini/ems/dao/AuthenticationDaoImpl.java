package com.capgemini.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.ems.bean.UserBean;
import com.capgemini.ems.exception.EMSException;

@Repository
@Transactional
public class AuthenticationDaoImpl implements IAuthenticationDao {

	@PersistenceContext
	EntityManager eManager;
	
	@Override
	public UserBean getUser(String userName, String userPassword) throws EMSException {
		
		UserBean user = null;
		try {
			String qStr = "SELECT user FROM UserBean user WHERE user.userName = :uname AND user.userPassword = :pwd";
			TypedQuery<UserBean> query = eManager.createQuery(qStr, UserBean.class);
			query.setParameter("uname", userName);
			query.setParameter("pwd", userPassword);
			user = query.getSingleResult();
		} catch (Exception e) {
			throw new EMSException(e.getMessage());
		}
		return user;
	}

}
