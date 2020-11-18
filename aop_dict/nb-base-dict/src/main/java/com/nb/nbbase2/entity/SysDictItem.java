package com.nb.nbbase2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict_item")
public class SysDictItem implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典表id
     */
    private Integer dictId;

    /**
     * 字典项文本
     */
    private String itemText;

    /**
     * 字典项值
     */
    private String itemValue;

    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 是否启动
     */
    private Integer status;


}
