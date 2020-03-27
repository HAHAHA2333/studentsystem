package com.example.demo.Service;

import com.example.demo.domain.student;
import com.example.demo.mapper.getAllMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class getAllStudentImpl implements getAllStudent {
    @Autowired
    getAllMapper getallmapper;
    @Override
    public PageInfo<student> getAllStudent(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<student> studentlist = getallmapper.getall();
        PageInfo<student> pageInfo = new PageInfo<student>(studentlist);
        return pageInfo;
    }

    @Override
    public PageInfo<student> queryBy(int pageNum, int pageSize,int achievement,int chinese,int maths,int english) {
        PageHelper.startPage(pageNum,pageSize);
        List<student> studentlist = getallmapper.queryBy(achievement,chinese,maths,english);
        PageInfo<student> pageInfo = new PageInfo<student>(studentlist);
        return pageInfo;
    }

    //导出excel用(所有报考学生)
    @Override
    public List<student> getAll() {
        List<student> getall = getallmapper.getall();
        return getall;
    }

    @Override
    public PageInfo<student> getstu(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<student> getstu = getallmapper.getstu();
        PageInfo<student> pageInfo = new PageInfo<student>(getstu);
        return pageInfo;
    }

    //导出excel用(所有已录取学生)
    @Override
    public List<student> getstu() {
        List<student> getstu = getallmapper.getstu();
        return getstu;
    }

    @Override
    public int del(String studentName,String id) {
        int del = getallmapper.del(studentName,id);
        return del;
    }

    @Override
    public int update(student stu) {
        int update = getallmapper.update(stu);
        return update;
    }


}
