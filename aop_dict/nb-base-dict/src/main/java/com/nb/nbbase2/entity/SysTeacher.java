package com.nb.nbbase2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.nb.nbbase2.constant.TeacherTitleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_teacher")
public class SysTeacher implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 教师名称
     */
    private String teacherName;

    /**
     * 职称(引用字典表)
     * 原生枚举（带{@link com.baomidou.mybatisplus.annotation.EnumValue}):
     */
    private TeacherTitleEnum title;


}
