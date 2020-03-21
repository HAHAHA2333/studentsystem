package com.example.demo.Dao;

import com.example.demo.domain.Admin;
import com.example.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDaoImpl implements AdminDao{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String teacherNo,String password) {
        Admin login = adminMapper.login(teacherNo, password);
        return login;
    }
}
