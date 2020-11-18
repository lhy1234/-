package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import com.example.demo.result.AppResult;
import com.example.demo.service.MailSender;
import com.example.demo.service.SysUserService;
import com.example.demo.validator.Assert;
import com.example.demo.validator.ValidatorUtils;
import com.example.demo.validator.group.AddGroup;
import com.example.demo.validator.group.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * create by lihaoyang on 2020/8/8
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MailSender mailSender;
    @Autowired
    SysUserService userService;

    @PostMapping("add")
    public AppResult addUser(@RequestBody  SysUser user){

        ValidatorUtils.validateEntity(user, AddGroup.class);

        userService.userRegister(user);
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

    @GetMapping("getUser")
    public AppResult getUser(int id){



        return AppResult.ok();
    }
}
