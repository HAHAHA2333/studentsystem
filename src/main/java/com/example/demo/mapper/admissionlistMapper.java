package com.example.demo.mapper;

import com.example.demo.domain.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface admissionlistMapper {
     //插入学生
     int insertStudent(List<student> list) ;
     //查看每个专业已经录取的人数
     int countEveryDeptMember(String subjectCategory);
     //随机分配过线但没被报考专业录取的学生到其他没满的系
     int randomInsertstudent(@Param(value = "id") int id, @Param(value = "deptid") int deptid);
     //更新已被录取的学生的used
     int updateStudent(List<student> list);
     //更新已被随机录取的学生的used
     int updateRandomStudent(int id);
     //软删除录取表
     int del(String id);

}
