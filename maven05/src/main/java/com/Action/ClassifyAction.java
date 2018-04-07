package com.Action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Entity.Classify;
import com.Entity.User;
import com.Service.ClassifyService;
import com.Tool.Page;
import com.Tool.Tool;
@SessionAttributes(value={"user"})
@Controller
public class ClassifyAction extends BaseAction{
	
	@Autowired 
	private ClassifyService service;
	
@RequestMapping("/classify_list")
 public String classify_list(Model model,@RequestParam( value="c",defaultValue="1") int c )
  {
	Page<Classify>p=new Page<Classify>(c, 10, service.getClassifies());
	model.addAttribute("list", p.getResult());
	model.addAttribute("page", p);
	  return "classify_list";
  }

@RequestMapping("/show_add_classify")
  public String show_add_classify(HttpServletRequest request)
  {
  /* HttpSession session=request.getSession();
   User user=(User) session.getAttribute("user");*/
   
	return "add_classify";
  }
  @RequestMapping("/add_classify")
  public String add_classify(Classify classify,Model model)
  {
	 classify.setTime(Tool.getCTime());
	  service.add(classify);
	  return classify_list(model,1);
  }
  @RequestMapping("/show_update_classify")
  public String show_update_classify(Model model,Classify classify)
  {
	  model.addAttribute("c",service.getClassify(classify) );
	  return "update_classify";
  }
  @RequestMapping("/update_classify")
  public String update_classify(Model model,Classify classify)
  {
	  //?
	  service.update(classify);
	  return classify_list(model,1);
  }
  @RequestMapping("/delete_classify")
  public String del_classify(Model model,Classify classify)
  {
	 service.delete(classify);
	  return classify_list(model,1);
  }
   
}
