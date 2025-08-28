package com.rays.autowire.byName;

public class UserService {
	
	private UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public void testAdd() {
		userDao.add();
	}

}
