package com.example.demo.Service;

import com.example.demo.domain.dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface getAllDept {
    PageInfo<dept> getAllDept(int pageNum, int pageSize);
    List<dept> getalldept();
}
