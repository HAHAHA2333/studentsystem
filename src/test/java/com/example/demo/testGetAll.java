package com.example.demo;

import com.example.demo.domain.student;
import com.example.demo.mapper.getAllMapper;
import com.example.demo.mapper.testMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
// 这块需要引入依赖 mybatis的测试依赖jar
@MybatisTest
// 这个注解的意义是指定了默认数据源
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class testGetAll {
    @Autowired
    getAllMapper getallmapper;
    @Test
    public void getAll() {
        List<student> list = getallmapper.getall();
        for (student s: list) {
            System.out.println(s.getId()+""+s.getStudentname()+
                    ""+s.getAchievement()+""+s.getMaths()+""+
                    s.getEngllish()+s.getDept().getDeptName());
        }
    }
}
