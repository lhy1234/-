package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * create by lihaoyang on 2020/8/10
 */
@Service
public class SysUserService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ApplicationContext applicationContext;


    public void userRegister(SysUser user){

        System.err.println("用户注册成功："+user.toString());

        //发布UserRegisterEvent事件
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
    }

}
