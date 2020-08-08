/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.example.demo.exception;

/**
 * 自定义异常
 */
public class NBException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public NBException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public NBException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public NBException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public NBException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
