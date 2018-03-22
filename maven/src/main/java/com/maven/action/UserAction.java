package com.maven.action;

import com.maven.entity.User;
import com.maven.ifa.UserIfa;
import com.maven.service.UserService;
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


@Controller
public class UserAction {

    private  static  final String SUCCESS="success";

    private  static  final String ERROR="error";

    @Autowired
    private UserService userService;

    @GetMapping("/update")
    public String updateUser()
    {
    return SUCCESS;
    }
    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model)
    {

        List<ObjectError> list=bindingResult.getAllErrors();
        FieldError name=bindingResult.getFieldError("userName");
        FieldError pass=bindingResult.getFieldError("age");

        if(bindingResult.hasErrors())
        {

            if(name!=null)
            {
                model.addAttribute("name", name.getDefaultMessage());

            }
            if(pass!=null)
            {
                model.addAttribute("age", pass.getDefaultMessage());
            }
         return "index";
        }
        userService.insert(user);
        return SUCCESS;
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
     public  String test(Model model, HttpServletRequest request)
        {
            User user=null;
            model.addAttribute("list", user.getId());
            request.setAttribute("key", "hello");
            return "index";
        }

        @ResponseBody
        @RequestMapping(value = "/json",method = RequestMethod.GET)

         public Map getInfo()
        {
            Map<String,Object> map=new HashMap<>();
            map.put("name", "1111");
            return  map;
        }
}
