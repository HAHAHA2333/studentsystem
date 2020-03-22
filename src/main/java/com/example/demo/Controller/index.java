package com.example.demo.Controller;

import com.example.demo.Dao.testDao;
import com.example.demo.domain.studentscott;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/index")
public class index {
    @Autowired
    testDao testdao;
    @GetMapping("/index")
    public ModelAndView hello(){
        return new ModelAndView("index.html");
    }
    @GetMapping("/test")
    public List<studentscott> getData(){
        return testdao.test() ;
    }
}
