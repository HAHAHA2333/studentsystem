package com.example.demo.Controller;

import com.example.demo.Service.getAllStudent;
import com.example.demo.Utils.ExcelUtil;
import com.example.demo.domain.ExcelData;
import com.example.demo.domain.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ExcelController {
    @Autowired
    getAllStudent getallstudent;

    @GetMapping("/getAllexcel")
    public void getAllexcel(HttpServletResponse response) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("所有人");
        List<student> all = getallstudent.getAll();
        List<String> titles = new ArrayList();
        titles.add("姓名");
        titles.add("性别");
        titles.add("成绩");
        titles.add("语文成绩");
        titles.add("数学成绩");
        titles.add("英语成绩");
        titles.add("系别");
        titles.add("专业");
        data.setTitles(titles);
        List<student> stuList = getallstudent.getAll();

        List<List<Object>> rows = new ArrayList();
        for (student stu: stuList){
            List<Object> row  = new ArrayList<Object>();
             row.add(stu.getStudentname());
             row.add(stu.getSex());
             row.add(stu.getAchievement());
             row.add(stu.getChinese());
             row.add(stu.getMaths());
             row.add(stu.getEngllish());
             row.add(stu.getDept().getDeptName());
             if(stu.getUsed()==1){
                 row.add("已录取");
             }else{
                 row.add("未录取");
             }
             rows.add(row);
        }
        data.setRows(rows);
        SimpleDateFormat fdate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName=fdate.format(new Date());
        ExcelUtil.exportExcel(response, "所有人"+fileName, data);
    }
    @RequestMapping("/getyiluquExcel")
    public void getyiluquExcel(HttpServletResponse response) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("已录取名单");
        List<student> all = getallstudent.getAll();
        List<String> titles = new ArrayList();
        titles.add("姓名");
        titles.add("性别");
        titles.add("成绩");
        titles.add("语文成绩");
        titles.add("数学成绩");
        titles.add("英语成绩");
        titles.add("系别");
        titles.add("专业");
        data.setTitles(titles);
        List<student> stuList = getallstudent.getstu();

        List<List<Object>> rows = new ArrayList();
        for (student stu: stuList){
            List<Object> row  = new ArrayList<Object>();
            row.add(stu.getStudentname());
            row.add(stu.getSex());
            row.add(stu.getAchievement());
            row.add(stu.getChinese());
            row.add(stu.getMaths());
            row.add(stu.getEngllish());
            row.add(stu.getDept().getDeptName());
            row.add(stu.getDept().getSubjectCategory());
            rows.add(row);
        }
        data.setRows(rows);
        SimpleDateFormat fdate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName=fdate.format(new Date());
        ExcelUtil.exportExcel(response,"已录取"+fileName, data);
    }

}
