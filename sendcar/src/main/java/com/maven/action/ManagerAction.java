package com.maven.action;

import com.maven.dao.DepartmentDao;
import com.maven.dao.DispatchListDao;
import com.maven.dao.ManagerDao;
import com.maven.dao.UserDao;
import com.maven.entity.Department;
import com.maven.entity.DispatchList;
import com.maven.entity.Manager;
import com.maven.entity.User;
import com.maven.ifa.DepartmentIfa;
import com.maven.ifa.UserIfa;
import com.maven.service.UserService;

import com.maven.tool.Tool;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
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
    private DispatchListDao dispatchListDao;


    @Autowired
    UserDao userDao;


    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping(value = "/login")
    /*登录*/
    public String login(com.maven.entity.Manager manager, Model model,HttpServletRequest request)
    {
       if(managerDao.findUser(manager)!=null)
       {
           com.maven.entity.Manager man=managerDao.findUser(manager);
           model.addAttribute("man", man);


           System.out.println(request.getServletContext().getRealPath("/excel"));


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
    /*注册用户*/
    @RequestMapping("/register")
    public  String register(Manager manager,Model model)
    {
        if(manager.getAddress()!=null)
        {

        managerDao.addManager(manager);

        return "index";

        }
        return "register";
    }

   /* 确认表单*/

    @RequestMapping("/confirm")
    public  String confirm(DispatchList dispatchList,Model model)
    {
        dispatchList.setId(dispatchListDao.getCustomId());
        model.addAttribute("dis", dispatchList);
        return  "confirm_dispatchList";

    }
   /* 申请用车*/
    @RequestMapping("/request")
    public  String request(DispatchList dispatchList,Model model,HttpServletRequest request)
    {

        System.out.println("************"+dispatchList);
        if(dispatchList.getPeople()==null)
        {
            List<Department> list=departmentDao.findAll();
            model.addAttribute("list", list);
           return "add_dispatchList";
        }
      try {
       dispatchListDao.addOrUpdate(dispatchList);
          Tool.createExcel(dispatchList, request.getServletContext().getRealPath("/excel"));
      }catch (Exception e)
      {
          e.printStackTrace();
          return ERROR;
      }
      return "home";

    }
    @RequestMapping("/success")
    public  String success(DispatchList dispatchList,Model model)
    {
        return  SUCCESS;

    }

    /*修改派车单*/
    @RequestMapping("updateDispatchList")
    public String update(DispatchList dispatchList,Model model)
    {
        if(dispatchList.getId()!=null&&(dispatchList.getPeople()==null||dispatchList.getPeople().equals("")))
        {
            model.addAttribute("dis", dispatchListDao.findOneById(dispatchList.getId()));
            List<Department> list=departmentDao.findAll();
            model.addAttribute("list", list);
            return "update_dispatchList";
        }
        try {

            System.out.println("----------------------------"+dispatchList);

            dispatchListDao.addOrUpdate(dispatchList);
            List<Department> list=departmentDao.findAll();
            model.addAttribute("list", list);
        }catch (Exception e)
        {
            return ERROR;
        }
        return  "home";
    }
    /*删除派车单*/
    @RequestMapping("deleteDispatchList")
    public String deleteDispatchList(DispatchList dispatchList,Model model)
    {
        try {
            dispatchListDao.delete(dispatchList);
            List<Department> list=departmentDao.findAll();
            model.addAttribute("list", list);
        }catch (Exception e)
        {
            return ERROR;
        }
        return  "home";
    }
    /*退出登录*/

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        session.removeAttribute("man");
        return "index";
    }

    /*设置部门*/
    @RequestMapping("/setDep")
    public String setDep(HttpServletRequest request, Department department,Model model)
    {
        HttpSession session=request.getSession();
       loadData(model);

        if(department.getName()!=null){
          departmentDao.add(department);

        }

        return "add_department";
    }

    /*删除部门*/
    @RequestMapping("/delDep")
    public String delDep(HttpServletRequest request, Department department,Model model)
    {
        System.out.println(department);
        departmentDao.delete(department);
            loadData(model);
        return "add_department";
    }

    /*派车清单*/
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Department department,Model model)
    {
        List<DispatchList> list=dispatchListDao.getAll();
        model.addAttribute("list", list);
        return "show_dispatchlist";
    }


    private void loadData(Model model)
    {
        List<Department> list=departmentDao.findAll();
        model.addAttribute("list", list);
    }

    /* 文件下载*/
    @RequestMapping("download")
    public String downLoad(HttpServletResponse response, HttpServletRequest request,DispatchList dispatchList){
        String filename=dispatchList.getId()+".xls";
        String filePath = request.getServletContext().getRealPath("/excel") ;
        File file = new File(request.getServletContext().getRealPath("/excel")+ filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
    /*查询*/
    @RequestMapping("search")
    public String search(Model model,DispatchList dispatchList)
    {

        if(dispatchList.getId()!=null&&!dispatchList.getId().equals(""))
        {
            List<DispatchList> list=dispatchListDao.getDispatchlistBySal(dispatchList);
            model.addAttribute("list", list);
            return "result_dispatchlist";
        }
         return "search";
    }

}
