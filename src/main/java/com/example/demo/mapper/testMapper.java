package com.example.demo.mapper;

import com.example.demo.domain.studentscott;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface testMapper {
   public List<studentscott> test();
}
