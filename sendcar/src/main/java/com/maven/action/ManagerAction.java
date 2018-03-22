package com.maven.action;

import com.maven.dao.DispatchListDao;
import com.maven.dao.ManagerDao;
import com.maven.entity.DispatchList;
import com.maven.entity.Manager;
import com.maven.entity.User;
import com.maven.ifa.UserIfa;
import com.maven.service.UserService;

import com.sun.org.apache.regexp.internal.REUtil;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SessionAttributes(value = {"man"})
@Controller
//@RequestMapping(value = "/user")
public class ManagerAction extends BaseAction{



    @Autowired
    private ManagerDao managerDao;

    @Autowired
    DispatchListDao dispatchListDao;

    @RequestMapping(value = "/login")
    /*登录*/
    public String login(com.maven.entity.Manager manager, Model model)
    {
       if(managerDao.findUser(manager)!=null)
       {
           com.maven.entity.Manager man=managerDao.findUser(manager);
           model.addAttribute("man", man);
           return "home";
       }
        return ERROR;
    }
    /*修改登录密码*/
    @RequestMapping("/updateLoginInfo")
    public String updateLoginInfo(Manager m, Model model)
    {
        if(managerDao.isUpdate(m))
        {
            return  SUCCESS;
        }
        return  ERROR;
    }
    /*注册*/
    @RequestMapping("/register")
    public  String register()
    {
     return  ERROR;
    }

   /* 申请用车*/
    @RequestMapping("/request")
    public  String request(DispatchList dispatchList)
    {
        if(dispatchList==null)
        {
         return "add_dispatchList";
        }
      try {
       dispatchListDao.addOrUpdate(dispatchList);
      }catch (Exception e)
      {
          return ERROR;
      }
      return  SUCCESS;

    }

    /*修改派车单*/
    @RequestMapping("updateDispatchList")
    public String update(DispatchList dispatchList)
    {
        if(dispatchList==null)
        {
            return "update_dispatchList";
        }
        try {
            dispatchListDao.addOrUpdate(dispatchList);
        }catch (Exception e)
        {
            return ERROR;
        }
        return  SUCCESS;
    }
    /*删除派车单*/
    @RequestMapping("deleteDispatchList")
    public String deleteDispatchList(DispatchList dispatchList)
    {
        try {
            dispatchListDao.delete(dispatchList);
        }catch (Exception e)
        {
            return ERROR;
        }
        return  SUCCESS;
    }
}
