package com.example.demo.mapper;

import com.example.demo.domain.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface getAllMapper {
    //查询全部学生
    public List<student> getall();

    //按照筛选条件查询
    public List<student> queryBy(@Param("achievement") int achievement, @Param("chinese")int chinese,@Param("maths") int maths, @Param("english")int english);

    //查询已录取名单
    public abstract  List<student> getstu();
}
