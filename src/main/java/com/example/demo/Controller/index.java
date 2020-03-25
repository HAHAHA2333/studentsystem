package com.example.demo.Controller;

import com.example.demo.Dao.testDao;
import com.example.demo.Utils.ExcelUtil;
import com.example.demo.domain.ExcelData;
import com.example.demo.domain.studentscott;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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



//这个是用来测试excelutils
     @GetMapping("/exceltest")
    public void ExcelTest(HttpServletResponse response) throws Exception {
         ExcelData data = new ExcelData();
         data.setName("高考成绩");
         //添加标题(第一行)
         List<String> titles = new ArrayList();
         titles.add("学生");
         titles.add("学号");
         titles.add("成绩");
         titles.add("电话");
         data.setTitles(titles);

         List<List<Object>> rows = new ArrayList();
         List<Object> o1  = new ArrayList<Object>();
         o1.add("小白");
         o1.add("小白");
         o1.add("小白");
         o1.add("小白");
         List<Object> o2  = new ArrayList<Object>();
         o2.add("小红");
         o2.add("小红");
         o2.add("小红");
         o2.add("小红");
         List<Object> o3  = new ArrayList<Object>();
         o3.add("小红");
         o3.add("小红");
         o3.add("小红");
         o3.add("小红");

         rows.add(o1);
         rows.add(o2);
         rows.add(o3);

         data.setRows(rows);


         SimpleDateFormat fdate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
         String fileName=fdate.format(new Date());
         ExcelUtil.exportExcel(response, fileName, data);


     }
       @RequestMapping("/left")
     public  ModelAndView left(){
        return new ModelAndView( "common/left");

       }


}
