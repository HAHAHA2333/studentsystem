package com.example.demo.Controller;

import com.example.demo.Dao.AdminDao;
import com.example.demo.Dao.AdminDaoImpl;
import com.example.demo.domain.Admin;
import com.example.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginAndRegister {

    @Autowired
    private AdminDao adminDao;

    //管理员注册和登录页面
    @GetMapping("/lAndRview")
    public String lAndRview(){
     //   System.out.println("xxxxxxxxxxxxxxxxx");
        return "LoginAndRigister/index";
    }

    //登录操作
    @PostMapping("/login")
    public String login(HttpSession session, Admin admin, Map<String,Object> map){

        String teacherNo = admin.getTeacherNo();
        String password = admin.getPassword();
        Admin login = adminDao.login(teacherNo, password);
        if(login !=null){
         // System.out.println("登陆成功");
            session.setAttribute("teacherName",login.getTeacherName());

            //到时候改为查询所有学生的页面(现在是跳回首页)
            return "index";

        }else{
            map.put("msg","工号或密码错误");
            return "LoginAndRigister/index";
        }
    }

    //注销(退出)
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("teacherName");
        session.invalidate();
        //System.out.println("退出");
        return "redirect:/lAndRview";
      }

    //注册操作
    @PostMapping("/regist")
    public String regist(Admin admin,Map<String,Object> map){
        String teacherName = admin.getTeacherName();
        String teacherNo = admin.getTeacherNo();
        //判断此老师是否存在





        //判断





        return "/lAndRview";
    }





}
