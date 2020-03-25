package com.example.demo.Service;

import com.example.demo.domain.dept;
import com.github.pagehelper.PageInfo;

public interface getAllDept {
    PageInfo<dept> getAllDept(int pageNum, int pageSize);
}
