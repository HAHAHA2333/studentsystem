package com.example.demo.Dao;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Teacher;
import org.springframework.stereotype.Service;

public interface TeacherDao {
    public  abstract Teacher findByone(Admin admin);


}
