package com.example.demo.mapper;

import com.example.demo.domain.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface passStudentMapper {
    public List<student> passstudent(@Param("achievement")int achievement,
                                     @Param("chinese") int chinese,
                                     @Param("maths")int maths,
                                     @Param("english")int english,
                                     @Param("total")int total);
}
