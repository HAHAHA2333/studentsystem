package com.example.demo.Dao;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Teacher;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    TeacherMapper teacherMapper;


    @Override
    public Teacher findByone(Admin admin) {
        Teacher one = teacherMapper.findByone(admin);
        return one;
    }
}
