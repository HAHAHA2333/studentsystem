package com.example.demo;

import com.example.demo.domain.student;
import com.example.demo.mapper.getAllDeptMapper;
import com.example.demo.mapper.getAllMapper;
import com.example.demo.mapper.testMapper;
import com.sun.xml.internal.stream.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
// 这块需要引入依赖 mybatis的测试依赖jar
@MybatisTest
// 这个注解的意义是指定了默认数据源
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class testGetAll {
    @Autowired
    getAllMapper getallmapper;
    @Autowired
    getAllDeptMapper getalldeptmapper;
    @Test
    public void getAll() {
        List<student> list = getallmapper.getall();

        for (student s: list) {
            System.out.println(s.getId()+""+s.getStudentname()+
                    ""+s.getAchievement()+""+s.getMaths()+""+
                    s.getEngllish()+s.getDept().getDeptName());
        }
    }
    @Test
    public void getalldept() {
       // System.out.println(getalldeptmapper.getalldeptmapper());
        Map<String,String> map = new HashMap<>();
        map.put("test","t");
        map.put("01","1");
        System.out.println(map.get("test")+""+map.values()+"----"+map.keySet());
        Set<String> s = map.keySet();
        for (String str: s ) {
            System.out.println(str);
        }
     }
}
