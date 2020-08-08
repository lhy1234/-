package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import com.example.demo.result.AppResult;
import com.example.demo.validator.ValidatorUtils;
import com.example.demo.validator.group.AddGroup;
import com.example.demo.validator.group.UpdateGroup;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lihaoyang on 2020/8/8
 */
@RestController
@RequestMapping("/users")
public class UserController {


    @PostMapping("add")
    public AppResult addUser(@RequestBody SysUser user){

        ValidatorUtils.validateEntity(user, AddGroup.class);

        return AppResult.ok();
    }

    /**
     * 修改用户
     */
    @PostMapping("/update")
    public AppResult update(@RequestBody SysUser user){
        ValidatorUtils.validateEntity(user, UpdateGroup.class);
        return AppResult.ok();
    }

    @PostMapping("getUser")
    public AppResult getUser(){


        return AppResult.ok();
    }
}
