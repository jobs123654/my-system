package com.Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.Secure;
import com.Service.ClassifyService;
import com.Service.SecureService;
import com.Tool.Page;

@Controller
public class SecureAction extends BaseAction{
	
  @Autowired private ClassifyService cservice;
  
  @Autowired private SecureService service;
  
  @RequestMapping("/secure_list")
  public String secure_list(Model model,@RequestParam( value="c",defaultValue="1") int c )
  {
	  List<Secure>list=service.getSecures();
	  Page<Secure> page=new Page<Secure>(c, 10, list);
	  model.addAttribute("list", page.getResult());
	  model.addAttribute("page", page);
	  return "secure_list";
  }
  
  @RequestMapping("/show_add_secure")
  public String show_add_secure(Model model)
  {
	  model.addAttribute("con",cservice.getClassifies());
	  return "add_secure";
  }
  @RequestMapping("/show_secure_info")
  public String show_secure_info(Model model,Secure secure)
  {
	  model.addAttribute("i",service.getSecure(secure));
	  return "info_secure";
  }
  @RequestMapping("/show_update_secure")
  public String show_update_secure(Model model)
  {
	  return "update_secure";
  }
  @RequestMapping("/add_secure")
  public String add_secure(Model model,Secure secure)
  {
	  service.add(secure);
	  return secure_list(model,1);
  }
  @RequestMapping("/update_secure")
  public String update_secure(Model model,Secure secure)
  {
	  service.update(secure);
	  return secure_list(model,1);
  }
  @RequestMapping("/delete_secure")
  public String delete_secure(Model model,Secure secure)
  {
	  service.delete(secure);
	  return secure_list(model,1);
  }
  @RequestMapping("get_secure")
  public String get_secure(Model model,Secure secure)
  {
	  List<Secure>list=service.getSecures(secure);
	  model.addAttribute("list",list);
	  return "secure_page";
  }
  /*筛选保险*/
  @RequestMapping("choice")
  public String choice_secure(Model model,Secure secure)
  {
	  List<Secure>list=service.choiceSecure(secure);
	  model.addAttribute("list",list);
	  model.addAttribute("sum",list.size());
	  return "result_secure";
  }
  
  
  
	
}
