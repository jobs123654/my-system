package com.too;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionHelper {
   private static SqlSessionFactory sqlSessionFactory;
   
   private static ThreadLocal<SqlSession> sqLocal=new ThreadLocal<SqlSession>();
   private SqlSessionHelper(){ }
   synchronized public static SqlSessionFactory getSqlSessionFactory()
   {
	   try {
		if(sqlSessionFactory==null)
		{
			String path="config/mybatis-config.xml";
			InputStream inputStream=Resources.getResourceAsStream(path);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	   return sqlSessionFactory;
   }
   
   public static SqlSession getSession()
   {
	   SqlSession sqlSession=sqLocal.get();
	   if(sqlSession==null)
	   {
		   sqlSession=getSqlSessionFactory().openSession(true);
	   }
	   return sqlSession;
   }
   public static void commit()
   {
	   if(sqLocal.get()!=null)
	   {
		   sqLocal.get().commit();
		   sqLocal.get().close();
		   sqLocal.set(null);
	   }
   }
   public static void roback()
   {
	   if(sqLocal.get()!=null)
	   {
		   sqLocal.get().rollback();
		   sqLocal.get().close();
		   sqLocal.set(null);
		   
	   }
   }
}
