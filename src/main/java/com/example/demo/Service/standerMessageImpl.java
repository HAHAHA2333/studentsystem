package com.example.demo.Service;

import com.example.demo.domain.student;
import com.example.demo.mapper.admissionlistMapper;
import com.example.demo.mapper.getAllDeptMapper;
import com.example.demo.mapper.passStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class standerMessageImpl implements standerMessage {
    @Autowired
    getAllDeptMapper getalldeptmapper;
    @Autowired
    admissionlistMapper admissionlistmapper;
    @Autowired
    passStudentMapper passstudentmapper;

    @Override
    public Map<String, Double> setstanderMessage(String standerMessage) {
        //将文本域的参数切割便于存放
        String[] s = standerMessage.split("，");
        //创建个hashmap，用于存放专业和占比
        // Map<String,Map<String,Double>> stander = new HashMap<>();
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (i % 2 == 0) {
                if (i == s.length - 1) {
                } else {
                    map.put(s[i], Double.parseDouble(s[i + 1]));
                    //stander.put(s[i],map);
                }
            }
        }

        return map;
    }

    @Override
    public int insertdata(Map<String, Double> map, int achievement,
                          int chinese, int maths,
                          int english,
                          int total) {
        //创建set集合取出map的键，即专业，方便录取操作
        Set<String> set = null;
        set = map.keySet();
        //初始化每个专业计划的录取人数
        int peoples = 0;
        int i = 0;//初始化实际录取人数
        int pass = 0;//初始化等待随机分配的学生人数
        double zb=0.0;//初始化占比总数
        //初始化每个专业实际过线的人数
        List<student> passlist = new ArrayList<>();
        //存放过线但没被对应专业录取的人，即等待随机分配的学生
        List<student> notadmissiobutpass = new ArrayList<>();
        for (String s:set) {//计算总占比
            zb+= (map.get(s));
        }
        //验证前台输入的数据是否符合规定
        if (set.size() < getalldeptmapper.countalldeptmapper()) {
            return -1;
        }else if(zb>1){  //占比检验即判断占比之和是否>1,若>1则返回参数错误信息
            System.out.println("占比是-------------------------------"+zb);
            return -2;
        }else {
            //查询所有过线并且分组的人数
            List<student> students = passstudentmapper.passstudent(achievement, chinese, maths, english, total);
            for (String str : set) {
                //计算每个专业计划录取的人数
                peoples = (int) (map.get(str) * total);
                for (student ls : students) {
                    //用专业名称取出每个专业学生的信息
                    if (str.equals(ls.getDept().getSubjectCategory())) {
                        System.out.println(str + "计划" + peoples + "人");
                        //取计划人数内的过线人数录取
                        if (Double.parseDouble(passlist.size() + "") <= peoples - 1) {
                            passlist.add(ls);
                        } else {
                            notadmissiobutpass.add(ls);
                        }
                    }
                }
                if (passlist.size() > 0) {//录取
                    System.out.println(passlist.size()+"********************************");
                    i += admissionlistmapper.insertStudent(passlist);
                    //admissionlistmapper.updateStudent(passlist);
                    //更新used字段
                  for (student stu: passlist) {
                        admissionlistmapper.updateRandomStudent(stu.getId());
                    }
                    passlist.clear();
                }
            }
            //剩下过线没录取的人随机分配
           for (String str : set) {
                //计算每个专业计划录取的人数
                peoples = (int) (map.get(str) * total);
                int adm = admissionlistmapper.countEveryDeptMember(str);
                int deptid = getalldeptmapper.selectDeptId(str).getDeptid();
                if (adm < peoples && pass <= notadmissiobutpass.size()) {
                    //插入预计招生与实际招生的差值的人
                    for (int j = 0; j < (peoples - adm); j++) {
                        if (pass < notadmissiobutpass.size()) {
                            i += admissionlistmapper.randomInsertstudent(notadmissiobutpass.get(pass).getId(), deptid);
                            //更新used字段
                            admissionlistmapper.updateRandomStudent(notadmissiobutpass.get(pass).getId());
                            pass++;
                        }
                    }
                }
            }
        }return i;
    }
}
