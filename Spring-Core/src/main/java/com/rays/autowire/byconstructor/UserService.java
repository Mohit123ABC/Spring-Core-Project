package com.rays.autowire.byconstructor;

public class UserService {
	
	private UserDAO userDao;
	
	public UserService(UserDAO userDao) {
		// TODO Auto-generated constructor stub
		this.userDao = userDao;
	}
	
	public void testAdd() {
		userDao.add();
	}

}
