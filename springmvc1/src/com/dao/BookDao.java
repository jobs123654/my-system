package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Book;

public interface BookDao {
  List<Book> getBookList();
  
  List<Book> getBook (int  id);
  
  List<Book> testSql(@Param("id") String id,@Param("userName") String userName,@Param("userPassword") String userPassword);

 void updateBook(Book book);
 
 /*批量插入*/
 void insertBook(@Param("books") List<Book> books);
}
