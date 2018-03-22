package com.too;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.entity.User;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class DBOperate {
  public int insert(String sql,Map< String, Object> map)
  {
	  SqlSession sqlSession=SqlSessionHelper.getSession();
	  return sqlSession.insert(sql, map);
  }
  public int delete(String sql,Map<String, Object> map)
  {
	  return SqlSessionHelper.getSession().delete(sql,map);
  }
  public int update(String sql,Map<String, Object> map)
  {
	  return SqlSessionHelper.getSession().update(sql, map);
  }
  public java.util.List<Map<String, Object>> getList(String sql)
  {
	  /*分页处理*/
	  return SqlSessionHelper.getSession().selectList(sql);
  }
  public Map<String, Object> getUserMap(String sqString,Map<String, Object> map)
  {
	  return SqlSessionHelper.getSession().selectOne(sqString, map);

  }
}