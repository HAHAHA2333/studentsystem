package com.example.demo.mapper;

import com.example.demo.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    //管理员登录
    public abstract Admin login(String teacherNo,String password);

    //判断是否重复注册
    public abstract  Admin check(Admin admin);

    //注册
    public abstract  int register(Admin admin);


}
