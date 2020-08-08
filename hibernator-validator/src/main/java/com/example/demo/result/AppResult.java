package com.example.demo.result;

import java.io.Serializable;

/**
 * create by lihaoyang on 2020/8/8
 */
public class AppResult<T> implements Serializable {

    private int code;
    private String msg;

    private T data;

    public AppResult(){
        this.code = 200;
        this.msg = "成功";
    }

    public AppResult(int code ,String msg){
        this.code = code;
        this.msg = msg;
    }


    public AppResult(Object data){
        AppResult result = new AppResult();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
    }


    public static AppResult ok(){
        return new AppResult();
    }

    public static AppResult ok(Object data){
        return new AppResult(data);
    }

    public static AppResult error(){
        return new AppResult(500,"系统异常");
    }

    public static AppResult error(int code,String msg){
        return new AppResult(code,msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
