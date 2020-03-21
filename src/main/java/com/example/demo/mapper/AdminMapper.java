package com.example.demo.mapper;

import com.example.demo.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    //管理员登录
    public abstract Admin login(String teacherNo,String password);
}
