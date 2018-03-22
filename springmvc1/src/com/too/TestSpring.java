package com.too;

import com.dao.UserDao;

public class TestSpring {
	
  private UserDao userDao;
  
  /**
 * @return the userDao
 */
public UserDao getUserDao() {
	return userDao;
}

/**
 * @param userDao the userDao to set
 */
public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}

public void test()
  {
   System.out.println(userDao.getUser(3));
  }
}
