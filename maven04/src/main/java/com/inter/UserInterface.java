package com.inter;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import com.entity.User;
@MapperScan("user")
public interface UserInterface {
    
	
	@Insert("insert into user(name) values(#{name})")
	public void add(User user);
    @Update("update user set name=#{name} where id=#{id}")
    public void update(String name,int id);
    @Delete("delete from user where id=#{id}")
    public void delete(int id);
    @Select("select * from user")
    public List<User> getAll();
}
