package com.example.demo.mapper;

import com.example.demo.domain.Teacher;

public interface TeacherMapper {

    //注册时判断老师是否存在
    public abstract Teacher findByone();


}
