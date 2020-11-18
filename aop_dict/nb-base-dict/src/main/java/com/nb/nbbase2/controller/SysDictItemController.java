package com.nb.nbbase2.controller;


import com.nb.nbbase2.beans.Result;
import com.nb.nbbase2.constant.SysConstant;
import com.nb.nbbase2.entity.SysDictItem;
import com.nb.nbbase2.service.SysDictItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2020-10-28
 */
@Slf4j
@RestController
@RequestMapping("/sysDictItem")
public class SysDictItemController {

    @Autowired
    private SysDictItemService sysDictItemService;
    /**
     * @功能：新增
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @CacheEvict(value= SysConstant.SYS_DICT_CACHE, allEntries=true)//加在service方法
    public Result<SysDictItem> add(@RequestBody SysDictItem sysDictItem) {
        Result<SysDictItem> result = new Result<SysDictItem>();
        try {
            sysDictItemService.save(sysDictItem);
            result.success("保存成功！");
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            result.error500("操作失败");
        }
        return result;
    }

    /**
     * @功能：编辑
     * @param sysDictItem
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @CacheEvict(value=SysConstant.SYS_DICT_CACHE, allEntries=true)//也可以夹在service方法
    public Result<SysDictItem> edit(@RequestBody SysDictItem sysDictItem) {
        Result<SysDictItem> result = new Result<SysDictItem>();
        SysDictItem sysDict = sysDictItemService.getById(sysDictItem.getId());
        if(sysDict==null) {
            result.error500("未找到对应实体");
        }else {
            boolean ok = sysDictItemService.updateById(sysDictItem);
            if(ok) {
                result.success("编辑成功!");
            }
        }
        return result;
    }

}

