package com.test;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController{
	/*
	 * spring mvc 异常处理
	 * 
	 * 1 基于异常类
	 * 2 基于控制器
	 * 3 全局异常
	 * 
	 * 
*/ 
	@ExceptionHandler
	public String exp(HttpServletRequest request,HttpServletResponse response,Exception exception)
	{
		request.setAttribute("er", exception);
//		CommonsMultipartResolver
		return "error";	
	}
}
