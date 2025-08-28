package com.rays.autowire.NoType;

public class UserService {
	
	 private UserDAO userDao;

	    // Setter method
	    public void setUserDao(UserDAO userDao) {
	        this.userDao = userDao;
	    }
	
	public void testAdd() {
		userDao.add();
	}

}
