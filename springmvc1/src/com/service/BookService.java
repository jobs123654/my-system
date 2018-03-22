package com.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.BookDao;
import com.dao.InsuranceexchangeMapper;
import com.entity.Book;
import com.entity.Insuranceexchange;
import com.entity.InsuranceexchangeExample;
import com.entity.InsuranceexchangeExample.Criteria;
import com.too.Page;
@Component("bookService")
@Controller
public class BookService {
	
	@Autowired
	private SqlSessionFactory SqlSessionFactory;
	
	@Autowired
	private BookDao bookDao;
	/**
	 * @return the bookDao
	 */
	public BookDao getBookDao() {
		return bookDao;
	}

	/**
	 * @param bookDao the bookDao to set
	 */
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	Page<Book> page=new Page<Book>();
	
   /**
	 * @return the page
	 */
	public Page<Book> getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Page<Book> page) {
		this.page = page;
	}

/**
	 * @return the sqlSessionFactory
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		return SqlSessionFactory;
	}

	/**
	 * @param sqlSessionFactory the sqlSessionFactory to set
	 */
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		SqlSessionFactory = sqlSessionFactory;
	}

@RequestMapping(value="/booklist/{c}",method=RequestMethod.GET )
   public String bookList(@PathVariable("c")  String c0,Model model)
   {
	int c=Integer.parseInt(c0);
	
	  bookDao =SqlSessionFactory.openSession().getMapper(BookDao.class);
	  
	  InsuranceexchangeMapper insuranceexchangeMapper=SqlSessionFactory.openSession().getMapper(InsuranceexchangeMapper.class);
	  
	  
	  List<Book> list=bookDao.getBookList();
	  List<Insuranceexchange> insuranceexchanges=insuranceexchangeMapper.selectByExample(null);
	  System.out.println("-----------"+insuranceexchanges.get(0));   
	  
	  InsuranceexchangeExample insuranceexchangeExample=new InsuranceexchangeExample();
	  
	  Criteria criteria=insuranceexchangeExample.createCriteria();
	  criteria.andEnjoycardnumberLike("%11%");
	  
	  List<Insuranceexchange> insuranceexchanges2=insuranceexchangeMapper.selectByExample(insuranceexchangeExample);
	  
	  System.out.println("++++++++++"+insuranceexchanges2);
	  
	  page.setCurrentPage(c);
	  page.setList(list);
	  page.setPageSize(2);
	  page.setTotalRecord(list.size());
	 
	  
	  int[]ar=new int[page.getTotalPage()];
	  for(int i=0;i<ar.length;i++)
	  {
		  ar[i]=i+1;
	  }
	  list=bookDao.getBookList().subList((c-1)*page.getPageSize(),(c-1)*page.getPageSize()+2 );
	  
	   Book book=new Book("111", 6);
//	   Criteria criteria=bookDao.c
	   model.addAttribute("list", list);
	   model.addAttribute("page", page);
	   model.addAttribute("total",ar);
	    return "index";   
   }
}
