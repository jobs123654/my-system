package com.tool;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;

public class MybatisUtil {
   public static SqlSessionFactory getFactory()
   {
	   String path="config.xml";
	   InputStream inputStream=MybatisUtil.class.getClassLoader().getResourceAsStream(path);
	   SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	   return sessionFactory;
   }
}
