package com.Tool;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.digester.Digester;

import com.Entity.BaseEntity;
import com.Entity.User;

public class Test {
	@org.junit.Test
  public  void test() throws Exception
  {
  String s="18332709273";
  String v=DigestUtils.md5Hex(s);
  System.out.println(DigestUtils.getDigest(v));
  }
}
