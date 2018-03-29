package com.action;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
public class UserAction {
    @Autowired
    private UserDao userDao;
   @RequestMapping("test")
    public String test()
   {
       List<User> list=userDao.findAll();
       System.out.println(list.get(0));
       return  "index";
   }
}
