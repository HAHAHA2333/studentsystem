package com.example.demo.Service;

import com.example.demo.mapper.admissionlistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class admissionlistserviceImpl implements admissionlistService {

    @Autowired
    admissionlistMapper admissionlistmapper;

    @Override
    public int del(String id) {
        int del = admissionlistmapper.del(id);
        return del;
    }

    @Override
    public int update(String studentNo, String deptNo) {
        int update = admissionlistmapper.update(studentNo,deptNo);
        return update;
    }
}
