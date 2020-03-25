package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;

//Excel实体
public class ExcelData  implements Serializable{

    //表头
    private List<String> titles;
    //内容
    private List<List<Object>> rows;
    //标签名
    private String name;

    public ExcelData(List<String> titles, List<List<Object>> rows, String name) {
        this.titles = titles;
        this.rows = rows;
        this.name = name;
    }

    public ExcelData() {
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
