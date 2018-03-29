package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.UserDao;
import com.Entity.User;
@Service
public class UserService {
 @Autowired
 private UserDao dao;
 
 /**
 * @return the dao
 */
public UserDao getDao() {
	return dao;
}
/**
 * @param dao the dao to set
 */
public void setDao(UserDao dao) {
	this.dao = dao;
}
 public void add(User user)
 {
	dao.add(user);
 }
 public List<User> getAll()
 {
	return  dao.findAll();
 }
}
