package com.nb.nbbase2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.nb.nbbase2.aspect.Dict;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 性别(0-默认未知,1-男,2-女)
     */
    @Dict(dictCode = "sex")
    private Integer sex;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 性别(1-正常,2-冻结)
     */
    @Dict(dictCode = "user_status")
    private Integer status;

    /**
     * 用户类型：1-老师；2-学生；3-管理员
     */
    @Dict(dictCode = "user_type")
    private Integer userType;

    /**
     * 允许性别
     */
    @Dict(dictCode = "sex")
    private String allowSex;


}
