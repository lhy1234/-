package com.example.demo.service;

import com.example.demo.entity.SysUser;
import org.springframework.context.ApplicationEvent;

/**
 * create by lihaoyang on 2020/8/10
 */
public class UserRegisterEvent extends ApplicationEvent {

    public SysUser user;

    /**
     *
     * @param source 发生事件的对象
     * @param user 注册用户对象
     */
    public UserRegisterEvent(Object source,SysUser user) {
        super(source);
        this.user = user;
    }





    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }
}
