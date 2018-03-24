package com.maven.action;

import com.maven.dao.DepartmentDao;
import com.maven.dao.DispatchListDao;
import com.maven.dao.ManagerDao;
import com.maven.dao.UserDao;
import com.maven.entity.Department;
import com.maven.entity.DispatchList;
import com.maven.entity.Manager;


import com.maven.tool.PageHelper;
import com.maven.tool.Tool;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.*;

import java.util.List;
@SessionAttributes(value = {"man"})
@Controller

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
    private void loadData(Model model,int c)
    {
        List<Department> list=departmentDao.findAll();


        PageHelper<Department> departmentPageHelper=new PageHelper<Department>(c,6,list);

        model.addAttribute("list", departmentPageHelper.getResult());
        model.addAttribute("page",departmentPageHelper );
        model.addAttribute("cu",c );


    }

    /*设置部门*/
    @RequestMapping("/setDep")
    public String setDep(@RequestParam(value = "cu" ,defaultValue = "1") int c, HttpServletRequest request, Department department,Model model)
    {
        HttpSession session=request.getSession();


        if(department.getName()!=null){
          departmentDao.add(department);

         }
        loadData(model,c);
        return "add_department";
    }

    /*删除部门*/
    @RequestMapping("/delDep")
    public String delDep(HttpServletRequest request, Department department,Model model)
    {
        System.out.println(department);
        departmentDao.delete(department);
        loadData(model,1);
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
    public String search(Model model, DispatchList dispatchList)
    {


        if(dispatchList.getId()!=null&&!dispatchList.getId().equals(""))
        {

            List<DispatchList> list=dispatchListDao.getDispatchlistBySal(dispatchList);
            System.out.println(list.size());
            PageHelper<DispatchList> pageHelper=new PageHelper<DispatchList>(1,7,list);
            model.addAttribute("page", pageHelper);

            model.addAttribute("list", pageHelper.getResult());
            model.addAttribute("cu", 1);

            return "result";
        }
         return "search";
    }
    @RequestMapping("home")
    public  String home()
    {
        return "home";
    }

    /*查询*/
    @RequestMapping("search1")
    public String search1(Model model, DispatchList dispatchList,  @RequestParam("cu") int c)
    {



            if((Object)c==null)
            {
                c=1;
            }
            int f=c==1?0:c;

            List<DispatchList> list=dispatchListDao.getAll();
            PageHelper<DispatchList> pageHelper=new PageHelper<DispatchList>(c,7,list);




            model.addAttribute("list", pageHelper.getResult());
            model.addAttribute("cu", c);
            model.addAttribute("page", pageHelper);
            return "result";

    }




}
