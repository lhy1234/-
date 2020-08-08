package com.example.demo.entity;

import com.example.demo.validator.group.AddGroup;
import com.example.demo.validator.group.UpdateGroup;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * create by lihaoyang on 2020/8/8
 */
public class SysUser {

    private Integer id;

    @NotBlank(message="用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;

    @NotBlank(message="密码不能为空", groups = AddGroup.class)
    private String password;

    @NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    private String realName;

    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
