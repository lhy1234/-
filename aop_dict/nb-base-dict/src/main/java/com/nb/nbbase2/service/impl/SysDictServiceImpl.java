package com.nb.nbbase2.service.impl;

import com.nb.nbbase2.constant.SysConstant;
import com.nb.nbbase2.entity.SysDict;
import com.nb.nbbase2.mapper.SysDictMapper;
import com.nb.nbbase2.service.SysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2020-10-28
 */
@Slf4j
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    /**
     * SpringCache
     * @param dictCode
     * @param dictItemValue
     * @return
     */
    @Cacheable(value = SysConstant.SYS_DICT_CACHE,key = "#dictCode+':'+#dictItemValue")
    @Override
    public String findTextByCodeAndDictItemValue(String dictCode, String dictItemValue) {
        log.info("字典查库，dictCode {} ,dictValue:{}",dictCode,dictItemValue);
        return sysDictMapper.findTextByCodeAndDictItemValue(dictCode,dictItemValue);
    }
}
