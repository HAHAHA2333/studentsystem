package com.example.demo.mapper;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {

    //注册时判断老师是否存在
    public abstract Teacher findByone(Admin admin);


}
