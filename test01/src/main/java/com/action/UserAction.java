package com.action;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/com")
public class UserAction {

    private static  final  String success="success";

    @RequestMapping("/say")
    public ModelAndView say(HttpServletRequest request)
    {
        String a= new SimpleDateFormat("yyyy").format(new Date());

        String path=request.getServletContext().getRealPath("/static");
        File file=new File(path);
        if(!file.exists())
        {

            System.out.println("文件不存在");
            if(file.isDirectory())
            {
                file.mkdir();
            }
        }
//        return  success;
        ModelAndView modelAndView=new ModelAndView("success");
       return  modelAndView;
    }

}
