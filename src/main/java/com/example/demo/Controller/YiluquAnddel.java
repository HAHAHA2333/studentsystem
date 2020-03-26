package com.example.demo.Controller;

import com.example.demo.Service.admissionlistService;
import com.example.demo.Service.getAllStudent;
import com.example.demo.domain.student;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YiluquAnddel {

    @Autowired
    getAllStudent getallstudent;
    @Autowired
    admissionlistService admissionlistservice;

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
}
