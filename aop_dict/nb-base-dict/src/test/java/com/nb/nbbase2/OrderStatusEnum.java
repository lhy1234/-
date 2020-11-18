package com.nb.nbbase2;

public enum OrderStatusEnum {

    NOT_PAY(0,"未支付"),
    PAID(1,"已支付"),
    CANCEL(2,"已取消")
    ;

    private final int code;
    private final String text;

    OrderStatusEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }
    //省略getter方法
}
