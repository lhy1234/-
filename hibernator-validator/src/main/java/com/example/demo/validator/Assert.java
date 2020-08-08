/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.example.demo.validator;

import com.example.demo.exception.NBException;
import org.apache.commons.lang3.StringUtils;

/**
 * 数据校验
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new NBException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new NBException(message);
        }
    }
}
