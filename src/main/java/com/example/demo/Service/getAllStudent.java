package com.example.demo.Service;

import com.example.demo.domain.student;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface getAllStudent {
    PageInfo<student> getAllStudent(int pageNum,int pageSize);
    PageInfo<student> queryBy(int pageNum,int pageSize,int achievement,int chinese,int maths,int english);
    List<student> getAll();//导出excel用，不使用分页
    PageInfo<student> getstu(int pageNum,int pageSize);//查询已录取学生
    List<student> getstu();

}
