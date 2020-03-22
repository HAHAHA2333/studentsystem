package com.example.demo.Dao;

import com.example.demo.domain.Admin;

public interface AdminDao {
        public abstract Admin login(String teacherNo,String password);

        public abstract  Admin check(Admin admin);

        public abstract  void register(Admin admin);

}
