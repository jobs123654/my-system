package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Book;
import com.entity.User;

public interface UserDao {
//	@Select(value="select userName name,userPassword pwd from user where id = #{id}")
	/*通过属性查询pojo*/
  User getUser(int id);
  
  Boolean add(User user);
  
  User getUser1(@Param("id") int id,@Param("userName") String name);
 
  /*将属性封装到map中
   * 多个参数 非pojo，不经常使用
   * */
  User getUserByMap(Map<String, Object> map);
  
  /*多个参数非pojo，但是经常使用 ，可以封装到transfer object（数据传输对象）*/
  
  /*注意:如果是list，set 或数组 要封装到nap中
   * 
   * */
  List<User> selectAll(String userName);
  /*单条记录封装到map*/
  Map<String, Object> getUserMap(int id);
  
 /* 多条记录封装到map*/
  @MapKey("id")
  Map<String, User> getUserMapList();
  
  /*联合查询*/
  List<Book> getSpecial();
  
  User getUserOne(int id);
}
