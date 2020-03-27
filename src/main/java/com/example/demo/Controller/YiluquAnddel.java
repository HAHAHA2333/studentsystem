package com.example.demo.Controller;

import com.example.demo.Service.admissionlistService;
import com.example.demo.Service.getAllDept;
import com.example.demo.Service.getAllStudent;
import com.example.demo.domain.dept;
import com.example.demo.domain.student;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class YiluquAnddel {

    @Autowired
    getAllStudent getallstudent;
    @Autowired
    admissionlistService admissionlistservice;
    @Autowired
    getAllDept depts;

    @GetMapping("/yiluqu")//查询已录取学生
    public ModelAndView Getyiluqu(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum){
        ModelAndView mav = new ModelAndView();
        PageInfo<student> s =getallstudent.getstu(pageNum,3);
        mav.setViewName("yiluqu");
        mav.addObject("all",s);
        return  mav;
    }

    //取消录取的学生
    @GetMapping("/del")
    public String del(String studentname,String id,@RequestParam(defaultValue = "1",value = "pageNum") int pageNum){
        int del = getallstudent.del(studentname,id);
        if(del>0){
            System.out.println("(软)删除成功");
        }
        int del1 = admissionlistservice.del(id);
        System.out.println(studentname+"xxxxx"+"id"+id+pageNum+"=="+del1);
        System.out.println(pageNum+"-------------");
        return  "redirect:/yiluqu?pageNum="+pageNum;
    }
    //更新考生信息
    @GetMapping("/updateView")
    public String updateView(Map<String,Object> map,student stu){
        List<dept> depts1 = depts.getalldept();
        map.put("depts",depts1);

        map.put("stu",stu);


        return "update";
    }
    //更新操作
    @PostMapping("/update")
    public String update(student stu){
        //修改学生表
        System.out.println(stu.getId()+"=="+stu.getMaths()+"---"+stu.getChinese());
        stu.setAchievement(stu.getChinese()+stu.getMaths()+stu.getEngllish());
        int update = getallstudent.update(stu);
        System.out.println(update);
      //  修改录取表


        int update2 = admissionlistservice.update(stu.getId() , stu.getDept().getDeptid());
        if(update>0 &&update2>0 ){
            System.out.println("success");
        }
          return "redirect:/yiluqu";
    }


}
