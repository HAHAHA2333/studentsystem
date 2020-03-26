package com.example.demo.Controller;
import com.example.demo.Service.getAllDeptImpl;
import com.example.demo.Service.standerMessage;
import com.example.demo.domain.dept;
import com.example.demo.mapper.getAllDeptMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class setStander {
    @Autowired
    standerMessage standermessage;
    @Autowired
    getAllDeptImpl getAllDept;
    @GetMapping("setStander")
    public ModelAndView setStander(@RequestParam(defaultValue = "0",value = "pageNum") int pageNum){
        return new ModelAndView("setStander").addObject("dept",getAllDept.getAllDept(pageNum,5));
    }
    @PostMapping("standerMessage")
    public ModelAndView standerMessage(@RequestParam(value = "standerMessage") String standerMessage,
                                       @RequestParam(defaultValue = "150",value = "achievement")int achievement,
                                       @RequestParam(defaultValue = "50",value = "chinese") int chinese,
                                       @RequestParam(defaultValue = "50",value = "maths") int maths,
                                       @RequestParam(defaultValue = "50",value = "english") int english,
                                       @RequestParam(defaultValue = "200",value = "total")int total){
        int i=standermessage.
                insertdata(standermessage.setstanderMessage(standerMessage),achievement,chinese,maths,english,total);
        if ( i== -1){
            return new ModelAndView("standerMessage").addObject("message","系别录取参数数量有误");
        }
        if ( i== -2){
            return new ModelAndView("standerMessage").addObject("message","系别录取占比有误");
        }
       return new ModelAndView("standerMessage");
    }
}
