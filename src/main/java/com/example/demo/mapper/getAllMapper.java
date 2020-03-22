package com.example.demo.mapper;

import com.example.demo.domain.student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface getAllMapper {
    //查询全部学生
    public List<student> getall();
    //按照筛选条件查询
    public List<student> queryBy(int achievement,int chinese,int maths,int english);
}
