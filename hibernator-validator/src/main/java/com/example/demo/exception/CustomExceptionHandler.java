package com.example.demo.exception;

import com.example.demo.result.AppResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * create by lihaoyang on 2020/8/8
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(NBException.class)
    public AppResult handleRRException(NBException e){
        logger.error(e.getMessage(), e);
        return AppResult.error(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public AppResult handleException(Exception e){
        logger.error(e.getMessage(), e);
        return AppResult.error();
    }
}
