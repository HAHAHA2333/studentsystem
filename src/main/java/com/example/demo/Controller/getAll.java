package com.example.demo.Controller;

import com.example.demo.Service.getAllStudent;
import com.example.demo.domain.student;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/index")
public class getAll {
    @Autowired
    getAllStudent getallstudent;
    @GetMapping("getall")
    public ModelAndView GetAll(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum){
    ModelAndView mav = new ModelAndView();
    PageInfo<student> s =getallstudent.getAllStudent(pageNum,3);
    mav.setViewName("AllStudent");
    mav.addObject("all",s);
    return  mav;
    }
}
