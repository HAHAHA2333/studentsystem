package com.example.demo.Service;

import com.example.demo.domain.dept;
import com.example.demo.domain.student;
import com.example.demo.mapper.getAllDeptMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class getAllDeptImpl implements getAllDept {
    @Autowired
    getAllDeptMapper getallDeptmapper;
    @Override
    public PageInfo<dept> getAllDept(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<dept> deptList = getallDeptmapper.getalldeptmapper();
        PageInfo<dept> pageInfo = new PageInfo<dept>(deptList);
        return pageInfo;
    }
    //获取所有
    public List<dept> getalldept(){
        List<dept> depts = getallDeptmapper.getalldeptmapper();
        return depts;
    }

}
