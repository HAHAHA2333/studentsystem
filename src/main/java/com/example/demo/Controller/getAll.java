package com.example.demo.Controller;

import com.example.demo.Service.getAllStudent;
import com.example.demo.domain.student;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    @GetMapping("queryBy")
    public ModelAndView queryBy(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                                @RequestParam(value = "achievement")int achievement,
                                @RequestParam(value = "chinese") int chinese,
                                @RequestParam(value = "maths") int maths,
                                @RequestParam(value = "english") int english){
        ModelAndView mav = new ModelAndView();
        PageInfo<student> s =getallstudent.queryBy(pageNum,3,achievement,chinese,maths,english);
        mav.setViewName("queryBy");
        String queryparam="&achievemen="+achievement+"&chinese="+chinese+"&maths="+maths+"&english="+english;
        mav.addObject("achievement",achievement);
        mav.addObject("chinese",chinese);
        mav.addObject("maths",maths);
        mav.addObject("english",english);
        mav.addObject("all",s);

        return  mav;
    }
}
