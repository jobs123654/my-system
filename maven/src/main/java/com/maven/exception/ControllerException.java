package com.maven.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerException {
   private  static  final  String DEFAULT_PAGE="error";
   @ExceptionHandler(value = Exception.class)
    public ModelAndView goError(HttpServletRequest request,Exception e) throws  Exception
   {
      ModelAndView modelAndView=new ModelAndView(DEFAULT_PAGE);
      modelAndView.addObject("error", e.getMessage());
      modelAndView.addObject("url", request.getRequestURI());
      return  modelAndView;
   }
}

