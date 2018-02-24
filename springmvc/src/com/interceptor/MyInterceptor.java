package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		if(request.getServletPath().startsWith("/upload"))
//		{
//			return true;
//		}
//		String user=(String) request.getSession().getAttribute("user");
//		if(user!=null)
//		{
//			return true;
//		}
//		
////		request.getRequestDispatcher("/view/add.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+ "/index.jsp");
//		System.out.println(request.getServletPath());
//		return false;
		return true;
	}
  
}
