package com.example.demo.Controller;

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
    @GetMapping("/yiluqu")//查询已录取学生
    public ModelAndView Getyiluqu(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum){
        ModelAndView mav = new ModelAndView();
        PageInfo<student> s =getallstudent.getstu(pageNum,3);
        mav.setViewName("yiluqu");
        mav.addObject("all",s);
        return  mav;
    }

}
