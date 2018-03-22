package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookDao;
import com.dao.InsuranceexchangeMapper;
import com.dao.UserDao;
import com.entity.Book;
import com.entity.Insuranceexchange;
import com.entity.User;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.too.DBOperate;
import com.too.SqlSessionHelper;
import com.too.TestSpring;

public class Test02 {

@Test	
	public void test() {


	User user=new User("1","2");
			
	
	Map< String, Object> map=new HashMap<String, Object>();
	map.put("userName", "11111111");
	map.put("userPassword", "root");
	map.put("userSex", 0);
	map.put("role", 0);
	
	map.put("useNumber", "11111111");
	
//	map.put("userSex", 0);
//	
//	map.put("userSex", 0);
	
	DBOperate dbOperate=new DBOperate();
	
//	dbOperate.insert("add", map);
	
	Map<String, Object> map2=new HashMap<String, Object>();
	map2.put("id",3);

	

	
//	java.util.List< Map<String, Object>> list=dbOperate.getList("selectAll");
//	
//	for(int i=0;i<maps.size();i++)
//	{
//		Book item=(Book) maps.get(i);
//		System.out.println(item.getId()+"   "+item.getName()+" "+item.getUid());
//	}
	
//	dbOperate.delete("delete", map2);
	
//	UserDao userDao=SqlSessionHelper.getSession().getMapper(UserDao.class);
	
//	java.util.List<User> users=userDao.selectAll("c");
	
//	System.out.println(users.size());
	
//	Map<String, Object> useMap=userDao.getUserMap(3);
	
//	System.out.println(useMap.get("userName"));
	
//	Map<String , User> uMap=userDao.getUserMapList();
	
//	System.out.println(uMap.get(3));
	
	
//	BookDao bookDao=SqlSessionHelper.getSession().getMapper(BookDao.class);
//	java.util.List<Book> books=bookDao.getBookList();
	
//	System.out.println(books.get(0));
	
	
	//System.out.println(user2);
	
//	TestSpring testSpring=(TestSpring)applicationContext.getBean("spring");
//	
//	testSpring.test();
//	
//	 java.util.List<Book> book=bookDao.testSql(null,null, null);
//	
//	  Book b=new Book("dog", 1);
//	  Book b1=new Book("cat", 2);
//	  java.util.List<Book> bList=new ArrayList<Book>();
//	  bList.add(b1);
//	  bList.add(b);
//	  bookDao.insertBook(bList);
//	  SqlSessionHelper.commit();
	
//	InsuranceexchangeMapper insuranceexchangeMapper=SqlSessionHelper.getSession().getMapper(InsuranceexchangeMapper.class);
//	java.util.List<Insuranceexchange> list=insuranceexchangeMapper.selectByExample(null);
//	System.out.println(list);
	
	java.util.List<Book> books=SqlSessionHelper.getSession().getMapper(BookDao.class).getBookList();
	System.out.println(books);
    
	
}
	

}
