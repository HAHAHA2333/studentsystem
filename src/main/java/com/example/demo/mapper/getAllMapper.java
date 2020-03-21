package com.example.demo.mapper;

import com.example.demo.domain.student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface getAllMapper {
    public List<student> getall();
}
