package com.nb.nbbase2.service;

import com.nb.nbbase2.entity.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-10-28
 */
public interface SysDictService extends IService<SysDict> {

    String findTextByCodeAndDictItemValue(String dictCode, String dictItemValue);
}
