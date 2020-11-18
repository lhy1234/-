package com.example.demo.service;

import com.example.demo.entity.SysUser;
import org.springframework.context.ApplicationListener;

/**
 * create by lihaoyang on 2020/8/10
 */
public class RegisterListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        //获取注册用户对象
        SysUser user = userRegisterEvent.getUser();

        //../省略逻辑

        //输出注册用户信息
        System.out.println("2注册信息，用户名："+user.getUsername()+"，密码："+user.getEmail());
    }
}
