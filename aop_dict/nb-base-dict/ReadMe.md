### 环境
springboot2.x + mysql5.7+redis

项目里有很多标识状态的字段，比如订单状态：0-未支付，1-已支付，2-已取消。
或者性别sex: 0-未知，1-男，2-女 。等等。
一般这种我们都会建相应的枚举类，比如

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


项目里一般都有字典表，我们写了枚举类，还需要把他们存在字典表么？