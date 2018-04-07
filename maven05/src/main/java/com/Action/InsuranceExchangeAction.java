package com.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.digester.Digester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.InsuranceExchange;
import com.Entity.Secure;
import com.Entity.User;
import com.Service.InsuranceExchangeService;
import com.Service.SecureService;
import com.Tool.Page;
import com.Tool.Tool;

@Controller
public class InsuranceExchangeAction {
  @Autowired 
  private InsuranceExchangeService service;
  
  @Autowired 
  private SecureService service1;
  
  /*保单列表*/
  @RequestMapping("/insuranceExchange_list")
     public String insuranceExchangeList(Model model,@RequestParam( value="c",defaultValue="1") int c )
   {
	 
	    List<InsuranceExchange> u=service.getAll();
	    Page<InsuranceExchange> page=new Page<InsuranceExchange>(c, 10, u);
      model.addAttribute("list",page.getResult() );
      model.addAttribute("page",page );
	  return "insuranceExchange_list";
     	
   }
  //添加保单
  @RequestMapping("add_insuranceExchange")
  public String add_insuranceExchange(InsuranceExchange insuranceExchange,Secure secure, Model model,HttpServletRequest request)
  {
  	if(request.getMethod().equals("GET"))
  	{
  	   	Secure s=service1.getSecureById(secure);
  	   	model.addAttribute("secure", s);
  		return "add_insuranceExchange";
  	}
  	
  	User user=(User) Tool.getHttpServletRequest().getSession().getAttribute("yw");
  
  	if(user!=null)
  	{
  		insuranceExchange.setUseNumber(user.getId());
  		service.add(insuranceExchange);	
  	}
   return insuranceExchangeList(model, 1);	
  }
  //修改保单
  @RequestMapping("update_insuranceExchange")
  public String update_insuranceExchange(InsuranceExchange insuranceExchange,Model model,HttpServletRequest request)
  {
  	if(request.getMethod().equals("GET"))
  	{
  		return "add_insuranceExchange";
  	}
  	service.update(insuranceExchange);
  	return insuranceExchangeList(model, 1);	
  }
  //删除保单
  @RequestMapping("delete_insuranceExchange")
  public String delete_insuranceExchange(InsuranceExchange insuranceExchange,Model model)
  {
  	service.delete(insuranceExchange);
  	return insuranceExchangeList(model, 1);	
  }
 
}
