package com.example.demo.Service;

import java.util.Map;

public interface standerMessage {
    //设置分数标准
    public Map<String,Double> setstanderMessage(String standerMessage);
    //插入录取数据
    int  insertdata( Map<String,Double> map, int achievement,
                     int chinese, int maths,
                     int english,
                     int total);

}
