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
}
