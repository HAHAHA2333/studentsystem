package com.example.demo.mapper;

import com.example.demo.domain.dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface getAllDeptMapper {
    //获取所有系别数量
    public int countalldeptmapper();
    List<dept> getalldeptmapper();
    dept selectDeptId(String subjectCategory);
}
