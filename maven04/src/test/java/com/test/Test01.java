package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;

import com.entity.User;
import com.inter.UserInterface;
import com.tool.MybatisUtil;

public class Test01 {
  public List<User> getList()
  {
	  SqlSessionFactory sqlSessionFactory=MybatisUtil.getFactory();
	  SqlSession sqlSession=sqlSessionFactory.openSession();
	  UserInterface mapper=sqlSession.getMapper(UserInterface.class);
	  List<User> list=mapper.getAll();
	  return list;
  }
  public void add(String name)
  {
	  SqlSessionFactory sqlSessionFactory=MybatisUtil.getFactory();
	  SqlSession sqlSession=sqlSessionFactory.openSession();
	  UserInterface mapper=sqlSession.getMapper(UserInterface.class);
	   mapper.add(name);  
  }
	@Test
  public void test()
  {
//		MapperScannerConfigurer
	  
	 add("2222");
  }
}
