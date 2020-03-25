package com.example.demo.Controller;

import com.example.demo.Dao.AdminDao;
import com.example.demo.Dao.AdminDaoImpl;
import com.example.demo.Dao.TeacherDao;
import com.example.demo.domain.Admin;
import com.example.demo.domain.Teacher;
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


    @Autowired
    private TeacherDao teacherDao;

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
            return  "redirect:/index/getall";

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
        String password = admin.getPassword();
       System.out.println(teacherName+"========"+teacherNo+"======"+password);
        //判断此老师是否已注册
        Admin check = adminDao.check(admin);
        if(check !=null ){
            System.out.println("你已经注册！"+check.getTeacherName());
            map.put("msg","工号"+check.getTeacherNo()+"你已近注册");
            return "LoginAndRigister/index";
        }


        //判断此老师是否存在教务人员中(存在就注册)
        Teacher teacher = teacherDao.findByone(admin);
        if(teacher !=null){
            //System.out.println("老师存在");
            //可以注册
            int register = adminDao.register(admin);
            if(register>0){
                System.out.println("register:"+register);
                return "redirect:/lAndRview";
            }else{
                System.out.println("register:"+register);
                map.put("msg","注册失败亲联系管理源");
                return "redirect:/lAndRview";
            }



        }else{
            map.put("msg","你不属于教务人员");
            return "LoginAndRigister/index";
        }








    }





}
