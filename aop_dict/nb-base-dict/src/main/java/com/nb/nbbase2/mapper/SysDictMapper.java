package com.nb.nbbase2.mapper;

import com.nb.nbbase2.entity.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-10-28
 */
@Repository
public interface SysDictMapper extends BaseMapper<SysDict> {

    String findTextByCodeAndDictItemValue(@Param("dictCode") String dictCode, @Param("dictItemValue") String dictItemValue);
}
