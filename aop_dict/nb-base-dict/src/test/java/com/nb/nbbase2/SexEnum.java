package com.nb.nbbase2;

public enum SexEnum {
    UNKNOWN(0,"未知"),
    MAN(1,"男"),
    WOMAN(2,"女");
    private final int code;
    private final String text;

    SexEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }
    //省略getter方法
}
