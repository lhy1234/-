package com.nb.nbbase2;

import com.alibaba.fastjson.JSONObject;
import com.nb.nbbase2.constant.TeacherTitleEnum;
import com.nb.nbbase2.entity.SysTeacher;
import com.nb.nbbase2.mapper.SysTeacherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lihaoyang
 * @date 2020/11/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    SysTeacherMapper teacherMapper;

    @Test
    public void insert(){
//        SysTeacher teacher = new SysTeacher();
//        teacher.setTeacherName("小羊");
//        teacher.setTitle(TeacherTitleEnum.FUJIAOSHOU);
//        teacherMapper.insert(teacher);
        List<SysTeacher> list = teacherMapper.selectList(null);
        for (SysTeacher tea : list) {
            System.err.println(JSONObject.toJSONString(tea));
        }
    }

    ////打印：
//
//        {"id":1,"teacherName":"牛贝","title":"JIANGSHI"}
//        {"id":2,"teacherName":"西决","title":"ZHUJIAO"}
//        {"id":3,"teacherName":"石竹","title":"FUJIAOSHOU"}
//        {"id":4,"teacherName":"樟树鱼","title":"JIAOSHOU"}
//        {"id":5,"teacherName":"小羊","title":"FUJIAOSHOU"}
//        {"id":6,"teacherName":"小羊","title":"FUJIAOSHOU"}
//        {"id":7,"teacherName":"小羊","title":"FUJIAOSHOU"}
//        {"id":8,"teacherName":"小羊","title":"FUJIAOSHOU"}
//        {"id":9,"teacherName":"小羊","title":"FUJIAOSHOU"}
}
