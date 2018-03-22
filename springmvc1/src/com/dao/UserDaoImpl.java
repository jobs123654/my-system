package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Book;
import com.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		
		return new User("uuu"+id, "2222");
	}

	@Override
	public Boolean add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser1(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getUserMap(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, User> getUserMapList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getSpecial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
