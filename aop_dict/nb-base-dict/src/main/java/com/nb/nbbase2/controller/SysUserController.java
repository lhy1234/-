package com.nb.nbbase2.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nb.nbbase2.beans.Result;
import com.nb.nbbase2.entity.SysUser;
import com.nb.nbbase2.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 
 * @since 2020-10-28
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("list")
    public Result<IPage<SysUser>> list(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                       @RequestParam(name="pageSize", defaultValue="10") Integer pageSize){
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("username","");
        Page<SysUser> page = new Page<>(pageNo, pageSize);
        IPage<SysUser> pageList = sysUserService.page(page, queryWrapper);
        Result<IPage<SysUser>> result = new Result<>();
        result.setResult(pageList);
        return result;
    }

}

