package com.example.demo.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class student {
    private Integer id;
    private String studentname;
    private String sex;
    private String origin;
    private String admissionschool;
    private String subjectcategory;
    private Integer achievement;
    private Integer chinese;
    private Integer maths;
    private Integer engllish;
    private Integer used;
    private dept dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }


    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getAdmissionschool() {
        return admissionschool;
    }


    public void setAdmissionschool(String admissionschool) {
        this.admissionschool = admissionschool == null ? null : admissionschool.trim();
    }

    public String getSubjectcategory() {
        return subjectcategory;
    }

    public void setSubjectcategory(String subjectcategory) {
        this.subjectcategory = subjectcategory == null ? null : subjectcategory.trim();
    }


    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMaths() {
        return maths;
    }
    public void setMaths(Integer maths) {
        this.maths = maths;
    }
    public Integer getEngllish() {
        return engllish;
    }
    public void setEngllish(Integer engllish) {
        this.engllish = engllish;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public com.example.demo.domain.dept getDept() {
        return dept;
    }

    public void setDept(com.example.demo.domain.dept dept) {
        this.dept = dept;
    }
}
