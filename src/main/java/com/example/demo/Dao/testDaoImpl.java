package com.example.demo.Dao;

import com.example.demo.domain.studentscott;
import com.example.demo.mapper.testMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class testDaoImpl implements testDao{

    @Autowired
    private testMapper testmapper;

    @Override
    public List<studentscott> test() {
        List<studentscott> list = testmapper.test();
        return list;
    }
}
