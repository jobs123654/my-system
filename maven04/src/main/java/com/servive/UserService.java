package com.servive;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.inter.UserInterface;

@Service("userService")
public class UserService {
    @Autowired
	private  SqlSessionFactory sqlSessionFactory;
    
    private SqlSession getSession()
    {
    	return sqlSessionFactory.openSession();
    }
 public void addUser(User user)
 {
	 SqlSession sqlSession=getSession();
	 UserInterface userInterface=sqlSession.getMapper(UserInterface.class);
	 userInterface.add(user);
	 System.out.println(userInterface.getAll().size());
 }
 

/**
 * @return the sqlSessionFactory
 */
public SqlSessionFactory getSqlSessionFactory() {
	return sqlSessionFactory;
}

/**
 * @param sqlSessionFactory the sqlSessionFactory to set
 */
public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	this.sqlSessionFactory = sqlSessionFactory;
}
}
