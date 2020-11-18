package com.nb.nbbase2.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 教师职称
 * @author lihaoyang
 * @date 2020/11/12
 */
public enum TeacherTitleEnum {

    ZHUJIAO(1, "助教"),
    JIANGSHI(2, "讲师"),
    FUJIAOSHOU(3, "副教授"),
    JIAOSHOU(4,"教授");

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String desc;



    TeacherTitleEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
    @JsonValue    //标记响应json值
    public String getDesc() {
        return desc;
    }
}
