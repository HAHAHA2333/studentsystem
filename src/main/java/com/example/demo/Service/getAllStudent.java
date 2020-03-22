package com.example.demo.Service;

import com.example.demo.domain.student;
import com.github.pagehelper.PageInfo;


public interface getAllStudent {
    PageInfo<student> getAllStudent(int pageNum,int pageSize);
    PageInfo<student> queryBy(int pageNum,int pageSize,int achievement,int chinese,int maths,int english);
}
